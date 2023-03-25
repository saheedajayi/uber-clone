package africa.semicolon.uberClone.services;


import africa.semicolon.uberClone.data.dtos.requests.RegisterDriverRequest;
import africa.semicolon.uberClone.data.dtos.responses.RegisterResponse;
import africa.semicolon.uberClone.data.models.Driver;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.web.multipart.MultipartFile;

public interface DriverService {
    RegisterResponse register(RegisterDriverRequest request, MultipartFile licenseImage);

}
