package designpatterns.adaptor;

import designpatterns.adaptor.cars.AudiA6;
import designpatterns.adaptor.cars.BugattiVeyron;
import designpatterns.adaptor.cars.Movable;
import designpatterns.adaptor.cars.MovableAdapter;
import designpatterns.adaptor.cars.MovableAdapterImpl;
import designpatterns.adaptor.mediaplayer.AudioPlayer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AdaptorPatternTest
{
    @Test
    public void whenConvertingMPHToKMPH_thenSuccessfullyConverted()
    {
        Movable bugattiVeyron = new BugattiVeyron();
        MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

        assertEquals(268, bugattiVeyron.getSpeed(), 0.00001);
        assertEquals(431.30312, bugattiVeyronAdapter.getSpeed(), 0.00001);
    }

    @Test
    public void audiA6()
    {
        Movable audiA6 = new AudiA6();
        MovableAdapter audiA6Adaptor = new MovableAdapterImpl(audiA6);

        assertEquals(210, audiA6.getSpeed(), 0.00001);
        assertEquals(337.9614, audiA6Adaptor.getSpeed(), 0.00001);
    }

    @Test
    public void audioPlayerDemo()
    {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
