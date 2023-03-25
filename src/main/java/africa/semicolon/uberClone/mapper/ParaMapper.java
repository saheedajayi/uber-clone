package africa.semicolon.uberClone.mapper;

import africa.semicolon.uberClone.data.dtos.requests.RegisterPassengerRequest;
import africa.semicolon.uberClone.data.models.AppUser;

public class ParaMapper {
    public static AppUser map(RegisterPassengerRequest request){
        AppUser appUser = new AppUser();
        appUser.setName(request.getName());
        appUser.setPassword(request.getPassword());
        appUser.setEmail(request.getEmail());
        return appUser;
    }
}
