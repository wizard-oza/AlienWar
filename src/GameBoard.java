import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameBoard implements Runnable {
	
	private Display display;
	private Thread thread;
	private Boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage test;
	public GameBoard() {
		
	}
	
	private void init() {
		
		display = new Display();
		test= ImageLoader.loadImage("/Game/res/Textures/player.png");
		
	}
	
    private void update() {
		
	}
    
    private void render() {
    	
    	bs = display.getCanvas().getBufferStrategy();
    	if(bs == null) {
    		display.getCanvas().createBufferStrategy(3);
    		return;
    	}
    	g = bs.getDrawGraphics();
    	
    	g.clearRect(0, 0, display.getWeight(), display.getHeight());
    	
    	g.drawImage(test, 100, 100,null);
    	
    	bs.show();
    	g.dispose();
    }
    
    public void run() {
		// TODO Auto-generated method stub
    	init();
    	while(running) {
    		update();
    		render();
    	}
    	stop();
		
	}
	
	public synchronized void start() {
		
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
    public synchronized void stop() {
    	
    	if(!running)
    		return;
    	
    	running = false;
    	
    	try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
