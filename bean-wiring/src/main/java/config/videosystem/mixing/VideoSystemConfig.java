package config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 					  import
 * VideoSystemConfig <-------  DVDConfig, DVDPlayerConfig
 */
@Configuration
@Import({ DVDConfig.class, DVDPlayerConfig.class })
public class VideoSystemConfig {

}
