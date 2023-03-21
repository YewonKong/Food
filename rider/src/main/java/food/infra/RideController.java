package food.infra;

import food.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/rides")
@Transactional
public class RideController {

    @Autowired
    RideRepository rideRepository;

    @RequestMapping(
        value = "rides/{id}/finish",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Ride finish(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /ride/finish  called #####");
        Optional<Ride> optionalRide = rideRepository.findById(id);

        optionalRide.orElseThrow(() -> new Exception("No Entity Found"));
        Ride ride = optionalRide.get();
        ride.finish();

        rideRepository.save(ride);
        return ride;
    }

    @RequestMapping(
        value = "rides/{id}/regi",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Ride regi(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /ride/regi  called #####");
        Optional<Ride> optionalRide = rideRepository.findById(id);

        optionalRide.orElseThrow(() -> new Exception("No Entity Found"));
        Ride ride = optionalRide.get();
        ride.regi();

        rideRepository.save(ride);
        return ride;
    }
}
