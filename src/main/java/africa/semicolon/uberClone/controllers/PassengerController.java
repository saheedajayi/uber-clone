package africa.semicolon.uberClone.controllers;

import africa.semicolon.uberClone.data.dtos.requests.RegisterPassengerRequest;
import africa.semicolon.uberClone.data.dtos.responses.ApiResponse;
import africa.semicolon.uberClone.data.dtos.responses.RegisterResponse;
import africa.semicolon.uberClone.services.PassengerService;
import com.github.fge.jsonpatch.JsonPatch;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/passenger")
@AllArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody RegisterPassengerRequest request) {
        RegisterResponse response = passengerService.register(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("all/{pageNumber}")
    public ResponseEntity<?> getAllPassengers(@PathVariable int pageNumber){
        var response = passengerService.getAllPassengers(pageNumber);
        return ResponseEntity.ok(response.getContent());
    }

    @GetMapping("{passengerId}")
    public ResponseEntity<?> getPassengerById(@PathVariable Long passengerId) {
        var foundPassenger = passengerService.getPassengerById(passengerId);
        return ResponseEntity.status(HttpStatus.OK).body(foundPassenger);
    }

    @PatchMapping(value = "{passengerId}", consumes = "application/json-patch+json")
    public ResponseEntity<?> updatePassenger(@PathVariable Long passengerId, @RequestBody JsonPatch updatePatch) {
        try {
            var response = passengerService.updatePassenger(passengerId, updatePatch);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @DeleteMapping("{passengerId}")
    public ResponseEntity<?> deletePassenger(@PathVariable Long passengerId) {
        passengerService.deletePassenger(passengerId);
        return ResponseEntity.ok(ApiResponse.builder().message("Passenger deleted successfully"));

    }
}