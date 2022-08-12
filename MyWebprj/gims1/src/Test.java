import com.gxnu.entity.Config;
import com.gxnu.service.IConfigService;
import com.gxnu.service.imp.ConfigService;

public class Test {

	public static void main(String[] args) {
		IConfigService configService = new ConfigService();
		Config config = configService.find();
		System.out.println(config.toString());

	}

}
