
package tms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="DeliveryCenter", url="http://localhost:8088")
public interface AllocationService {

    @RequestMapping(method= RequestMethod.POST, path="/allocations")
    public void changeOilType(@RequestBody Allocation allocation);

}