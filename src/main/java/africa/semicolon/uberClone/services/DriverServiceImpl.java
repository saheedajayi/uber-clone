package africa.semicolon.uberClone.services;

import africa.semicolon.uberClone.cloud.CloudService;
import africa.semicolon.uberClone.data.dtos.requests.RegisterDriverRequest;
import africa.semicolon.uberClone.data.dtos.responses.RegisterResponse;
import africa.semicolon.uberClone.data.models.AppUser;
import africa.semicolon.uberClone.data.models.Driver;
import africa.semicolon.uberClone.data.repositories.DriverRepository;
import africa.semicolon.uberClone.exception.ImageUploadException;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;
    private final CloudService cloudService;
    private final ModelMapper modelMapper;

    @Override
    public RegisterResponse register(RegisterDriverRequest request, MultipartFile licenseImage) {
        AppUser driverDetails = modelMapper.map(request, AppUser.class);
        driverDetails.setCreatedAt(LocalDate.now().toString());
        //Steps:
        //1. Upload driver's license image
        var imageUrl = cloudService.upload(licenseImage);
        if(imageUrl == null)
            throw new ImageUploadException("Driver Registration Failed!");

        //2. Create driver object
        Driver driver = Driver.builder()
                .userDetails(driverDetails)
                .licenseImage(imageUrl)
                .build();

        //3. Save driver
        Driver savedDriver = driverRepository.save(driver);

        return RegisterResponse.builder()
                .code(HttpStatus.CREATED.value())
                .id(savedDriver.getId())
                .isSuccessful(true)
                .message("Driver Registration Successful")
                .build();
    }
}
