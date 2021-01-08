package at.fhv.cqrs.commands.controller;

import at.fhv.cqrs.commands.BookroomCommand;
import at.fhv.cqrs.commands.CancleBookingCommand;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Controller("/commands")
public class RestCommandController {

    @Post(uri="/bookroom",  produces= APPLICATION_JSON)
    @Operation(summary = "Bookroom",
            description = "Bookroom",
            requestBody = @RequestBody(description = "Room Booking Command bookfrom and bookuntil sind Epochseconds https://www.unixtimestamp.com/index.php",content =@Content(mediaType = "application/json",
                    schema = @Schema(implementation = BookroomCommand.class)))
    )
    @ApiResponse(responseCode = "200", description = "Returns Message of Bookingprocess",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = HttpResponse.class)))
    )
    @Tag(name = "Command")
    public HttpResponse<String> bookRoom(@RequestBody @Body BookroomCommand value) {
        BookingService bookingService = new BookingService();
        int anwser = bookingService.bookRoom(value);
        if(anwser == -2){
            return HttpResponse.badRequest("Raum leider bereits belegt");
        }
        if( anwser < 0){
            return HttpResponse.badRequest("Ungültige dateneingabe");
        }

        return HttpResponse.ok("Ihre Bestell nummer: " + anwser);

    }

    @Post(uri="/cancleService",  produces= APPLICATION_JSON)
    @Operation(summary = "Canclebooking",
            description = "Canclebooking",
            requestBody = @RequestBody(description = "Cancle booking by bookingid",content =@Content(mediaType = "application/json",
                    schema = @Schema(implementation = CancleBookingCommand.class)))
    )
    @ApiResponse(responseCode = "200", description = "Cancled sucessfull",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = String.class)))
    )
    @Tag(name = "Command")
    public String canclebooking(@RequestBody @Body CancleBookingCommand value) {
        BookingService bookingService = new BookingService();
        try{
            bookingService.canclebooking(value);

        }catch(Exception e){
            return "Could not Cancle";
        }

        return "Sucessfull Cancled";


    }

}
