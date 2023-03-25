package africa.semicolon.uberClone.services;

import africa.semicolon.uberClone.data.dtos.requests.RegisterPassengerRequest;
import africa.semicolon.uberClone.data.dtos.responses.RegisterResponse;
import africa.semicolon.uberClone.data.models.AppUser;
import africa.semicolon.uberClone.data.models.Passenger;
import africa.semicolon.uberClone.data.repositories.PassengerRepository;
import africa.semicolon.uberClone.exception.BusinessLogicException;
import africa.semicolon.uberClone.mapper.ParaMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
@Slf4j
public class PassengerServiceImpl implements PassengerService{

    private final PassengerRepository passengerRepository;
    private static final int NUMBER_OF_ITEMS_PER_PAGE = 3;
    @Override
    public RegisterResponse register(RegisterPassengerRequest registerRequest) {
        AppUser appUser = ParaMapper.map(registerRequest);
        appUser.setCreatedAt(LocalDateTime.now().toString());
        Passenger passenger = new Passenger();
        passenger.setUserDetails(appUser);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return getRegisterPassengerResponse(savedPassenger);

    }

    @Override
    public Passenger getPassengerById(Long passengerId) {
        return passengerRepository.findById(passengerId).orElseThrow(()->
                new BusinessLogicException(
                        String.format("Passenger with id %d not found", passengerId)
                ));
    }

    @Override
    public Passenger updatePassenger(Long passengerId, JsonPatch updatePayload) {
        ObjectMapper mapper = new ObjectMapper();
        Passenger foundPassenger = getPassengerById(passengerId);
        //Passenger object to node
        JsonNode node = mapper.convertValue(foundPassenger, JsonNode.class);
        try{
            //apply patch
            JsonNode updateNode = updatePayload.apply(node);
            //node to Passenger Object
            var updatedPassenger = mapper.convertValue(updateNode, Passenger.class);
            updatedPassenger = passengerRepository.save(updatedPassenger);
            return updatedPassenger;
        }catch(JsonPatchException e){
//            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public Page<Passenger> getAllPassengers(int pageNumber) {
        if(pageNumber < 1) pageNumber = 0;
        pageNumber -= 1;
        Pageable pageable = PageRequest.of(pageNumber, NUMBER_OF_ITEMS_PER_PAGE);
        return passengerRepository.findAll(pageable);
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    private static RegisterResponse getRegisterPassengerResponse(Passenger savedPassenger) {
        RegisterResponse response = new RegisterResponse();
        response.setId(savedPassenger.getId());
        response.setCode(HttpStatus.CREATED.value());
        response.setSuccessful(true);
        response.setMessage("User Registration Successful");
        return response;
    }
}
