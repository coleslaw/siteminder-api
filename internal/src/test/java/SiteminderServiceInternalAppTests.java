import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class SiteminderServiceInternalAppTests {

    @Test
    public void contextLoads() {
    }
    
    
    
    
    
/*    @InjectMocks
    private SiteminderServiceImpl service;
    
    @Mock
    private SiteminderAvailRatesClient client;

    private AvailRateUpdateReqDTO availRateDTO;

    @Before
    public void setup() {
        availRateDTO = new AvailRateUpdateReqDTO();
        availRateDTO.setDateFrom("2018-09-25");
        availRateDTO.setDateTo("2018-09-30");
        availRateDTO.setFlexAllocation(10);
        availRateDTO.setRoomId("221718538");

    }

    @Test
    public void testUpdateRoomTypeFlexibleAllocation() throws Exception {
        Map<ResponseTypes, Object> responseMap = new EnumMap<>(ResponseTypes.class);
        AvailRateUpdateRQ availRateUpdateRQ = new AvailRateUpdateRQ();
        Mockito.when(client.doPut(availRateUpdateRQ)).thenReturn(responseMap);
        try {
            responseMap = service.updateRoomTypeFlexibleAllocation(availRateDTO);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
       
    }*/

}

