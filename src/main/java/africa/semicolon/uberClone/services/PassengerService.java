package africa.semicolon.uberClone.services;

import africa.semicolon.uberClone.data.dtos.requests.RegisterPassengerRequest;
import africa.semicolon.uberClone.data.dtos.responses.RegisterResponse;
import africa.semicolon.uberClone.data.models.Passenger;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.data.domain.Page;

public interface PassengerService {
    RegisterResponse register(RegisterPassengerRequest registerRequest);
    Passenger getPassengerById(Long passengerId);
    Passenger updatePassenger(Long passengerId, JsonPatch updatePayload);
    Page<Passenger> getAllPassengers(int pageNumber);
    void deletePassenger(Long id);
}
