package pl.adrian_komuda.manipulate_volume_object.services;

import org.bukkit.Location;
import org.bukkit.World;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.adrian_komuda.manipulate_volume_object.TestFlag;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith0Params;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith2Params;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class LocationServiceTest {

    @BeforeAll
    static void setTestFlag() {
        TestFlag.TEST_FLAG = true;
    }

    @Test
    void afterGetInstanceCallItShouldBeReturnedTheSameInstanceAlways() {
        // given
        var locationService1 = LocationService.getInstance();
        var locationService2 = LocationService.getInstance();

        // when
        // then
        assertThat(locationService1).isSameAs(locationService2);
    }

    @Test
    void afterFirstCallOfMarkLocationLocation1ShouldBeSetProperly() {
        // given
        var locationService = new LocationService();
        Location location = new Location(mock(World.class), 0D, 0D, 0D);

        // when
        locationService.markLocation(location);

        // then
        assertThat(locationService.getLocation1()).isSameAs(location);
    }

    @Test
    void afterFirstCallOfMarkLocationLocation2ShouldBeNull() {
        // given
        var locationService = new LocationService();
        Location location = new Location(mock(World.class), 0D, 0D, 0D);

        // when
        locationService.markLocation(location);

        // then
        assertThat(locationService.getLocation2()).isNull();
    }

    @Test
    void afterSecondCallOfMarkLocationLocation1ShouldBeSetProperly() {
        // given
        var locationService = new LocationService();
        Location location1 = new Location(mock(World.class), 0D, 0D, 0D);
        Location location2 = new Location(mock(World.class), 1D, 1D, 1D);

        // when
        locationService.markLocation(location1);
        locationService.markLocation(location2);

        // then
        assertThat(locationService.getLocation1()).isSameAs(location1);
    }

    @Test
    void afterSecondCallOfMarkLocationLocation2ShouldBeSetProperly() {
        // given
        var locationService = new LocationService();
        Location location1 = new Location(mock(World.class), 0D, 0D, 0D);
        Location location2 = new Location(mock(World.class), 1D, 1D, 1D);

        // when
        locationService.markLocation(location1);
        locationService.markLocation(location2);

        // then
        assertThat(locationService.getLocation2()).isSameAs(location2);
    }

    @Test
    void afterFirstCallOfMarkLocationMethodShouldReturnProperMessage() {
        // given
        var locationService = new LocationService();
        Location location = new Location(mock(World.class), 0D, 0D, 0D);
        String properAnswerMessage = MessagesWith0Params.LOCATION1_SET.getMessage();

        // when
        String answerMessage = locationService.markLocation(location);

        // then
        assertThat(answerMessage).isEqualTo(properAnswerMessage);
    }

    @Test
    void afterSecondCallOfMarkLocationMethodShouldReturnProperMessage() {
        // given
        var locationService = new LocationService();
        Location location1 = new Location(mock(World.class), 0D, 0D, 0D);
        Location location2 = new Location(mock(World.class), 0D, 0D, 0D);
        String properAnswerMessage = MessagesWith0Params.LOCATION2_SET.getMessage();

        // when
        locationService.markLocation(location1);
        String answerMessage = locationService.markLocation(location2);

        // then
        assertThat(answerMessage).isEqualTo(properAnswerMessage);
    }

    @Test
    void getLocationsAsMessage() {
        // given
        var locationService = new LocationService();
        String properAnswerMessage = MessagesWith2Params.GET_LOCATIONS.getMessage(String.valueOf((Object) null), String.valueOf((Object) null));

        // when
        String answerMessage = locationService.getLocationsAsMessage();

        // then
        assertThat(answerMessage).isEqualTo(properAnswerMessage);
    }

    @AfterAll
    static void unsetTestFlag() {
        TestFlag.TEST_FLAG =  false;
    }

}