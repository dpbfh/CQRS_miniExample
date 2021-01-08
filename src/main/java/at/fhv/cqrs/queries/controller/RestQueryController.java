package at.fhv.cqrs.queries.controller;

import at.fhv.cqrs.commands.BookroomCommand;
import at.fhv.cqrs.commands.CancleBookingCommand;
import at.fhv.cqrs.commands.controller.BookingService;
import at.fhv.cqrs.domain.read.BookingRead;
import at.fhv.cqrs.domain.read.HotelReadRepository;
import at.fhv.cqrs.domain.read.HotelReadRoom;
import at.fhv.cqrs.queries.GetBookingQuery;
import at.fhv.cqrs.queries.GetFreeRoomsQuery;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collection;
import java.util.List;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Controller("/query")
public class RestQueryController {

    @Post(uri="/bookings", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "Query",
            description = "Query",
            requestBody = @RequestBody(description = "Query from and to in Epoch seconds https://www.unixtimestamp.com/index.php",content =@Content(mediaType = "application/json",
                    schema = @Schema(implementation = GetBookingQuery.class)))
    )
    @ApiResponse(responseCode = "200", description = "Returns Query",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = GetBookingQuery.class)))
    )
    @Tag(name = "Query")
    public List<BookingRead> getBookings( @RequestBody @Body GetBookingQuery value ) {
        return Queryservice.getBookingReads(value);
    }

    @Post(uri="/freeRooms", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "Query",
            description = "Query",
            requestBody = @RequestBody(description = "Query from and to in Epoch seconds https://www.unixtimestamp.com/index.php",content =@Content(mediaType = "application/json",
                    schema = @Schema(implementation = GetFreeRoomsQuery.class)))
    )
    @ApiResponse(responseCode = "200", description = "Returns Query",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = HotelReadRoom.class)))
    )
    @Tag(name = "Query")
    public Collection<HotelReadRoom> getFreeRooms(@RequestBody @Body GetFreeRoomsQuery value ) {
        return Queryservice.getFreeRooms(value);
    }

}
