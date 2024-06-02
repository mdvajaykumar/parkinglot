package controller;

import dto.GenerateTicketRequestDto;
import dto.GenerateTicketResponseDto;
import dto.ResponseStatus;
import exception.InvalidGateException;
import exception.NoAvailableSpotException;
import models.Ticket;
import models.VehicleType;
import service.TicketService;

public class TicketController {

    private TicketService ticketService;



    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }


    // issue a ticket
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) {
        String vehicleNumber = request.getVehicleNumber();
        VehicleType vehicleType = request.getVehicleType();
        Long gateId = request.getGateId();

        Ticket ticket = new Ticket();
        GenerateTicketResponseDto response = new GenerateTicketResponseDto();

        try {
            ticket = ticketService.generateTicket(gateId, vehicleType, vehicleNumber);
        } catch (InvalidGateException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("Gate ID is invalid");
            return response;
        } catch (NoAvailableSpotException e) {
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("No parking spot available");
            return response;
        }

        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicketId(ticket.getId());
        response.setOperatorName(ticket.getOperator().getName());
        response.setSpotNumber(ticket.getParkingSpot().getNumber());

        return response;
    }


}
