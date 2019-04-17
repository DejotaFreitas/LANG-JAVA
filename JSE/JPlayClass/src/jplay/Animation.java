package jplay;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Animation extends GameImage {
	private int initialFrame;
	private int currFrame;
	private int finalFrame;
	private int totalFrames;
	private boolean playing;
	private boolean loop;
	private boolean drawable;
	private long[] frameDuration;
	private long totalDuration;
	private long lastTime;
	private boolean repeatAnimation;
	private int finalFram;
	private int initialFram;
	private int currAnimFrame;
	private int currAnimFram;
	private long[] timeEachFrame;
	private boolean canDraw;
	private boolean animationFinished;

	public Animation(String fileName, int totalFrames, boolean loop) {
		super(fileName);
		this.totalFrames = totalFrames;
		this.width = (this.image.getWidth(null) / totalFrames);
		this.height = this.image.getHeight(null);
		this.lastTime = System.currentTimeMillis();
		this.playing = true;
		this.drawable = true;
		this.frameDuration = new long[totalFrames];
		setSequence(0, totalFrames, loop);
	}

	public Animation(String fileName, int numFrames, int num) {
		super(fileName);
		this.width = (this.image.getWidth(null) / numFrames);
		this.height = (this.image.getHeight(null) / num);

		this.canDraw = true;
		this.repeatAnimation = true;
		this.finalFrame = numFrames;
		this.finalFram = num;
		this.initialFrame = 0;
		this.initialFram = 0;
		this.currAnimFrame = 0;
		this.currAnimFram = 0;
		this.timeEachFrame = new long[numFrames];
		setTimeChangeFrame(70L);
		this.lastTime = System.currentTimeMillis();
		this.animationFinished = false;
	}

	public void setTimeChangeFrame(long timeChangeFrame) {
		for (int i = 0; i < this.timeEachFrame.length; i++) {
			this.timeEachFrame[i] = timeChangeFrame;
		}
	}

	public Animation(String fileName, int totalFrames) {
		this(fileName, totalFrames, true);
	}

	public Animation(String fileName) {
		this(fileName, 1, true);
	}

	public void setDuration(int frame, long time) {
		this.frameDuration[frame] = time;
	}

	public long getDuration(int frame) {
		return this.frameDuration[frame];
	}

	public void setSequence(int initialFrame, int finalFrame) {
		setSequence(initialFrame, finalFrame, true);
	}

	public void setSequence(int initialFrame, int finalFrame, boolean loop) {
		setInitialFrame(initialFrame);
		setCurrFrame(initialFrame);
		setFinalFrame(finalFrame);
		setLoop(loop);
	}

	public void setSequenceTime(int initialFrame, int finalFrame, long time) {
		setSequenceTime(initialFrame, finalFrame, true, time);
	}

	public void setSequenceTime(int initialFrame, int finalFrame, boolean loop, long time) {
		setSequence(initialFrame, finalFrame, loop);
		time /= (finalFrame - initialFrame + 1);
		for (int i = initialFrame; i <= finalFrame; i++) {
			this.frameDuration[i] = time;
		}
	}

	public boolean isLooping() {
		return this.loop;
	}

	public void setTotalDuration(long time) {
		long timeFrame = time / this.totalFrames;
		this.totalDuration = (timeFrame * this.totalFrames);
		for (int i = 0; i < this.frameDuration.length; i++) {
			this.frameDuration[i] = timeFrame;
		}
	}

	public long getTotalDuration() {
		return this.totalDuration;
	}

	public void update() {
		if (this.playing) {
			long time = System.currentTimeMillis();
			if ((time - this.lastTime > this.frameDuration[this.currFrame]) && (this.finalFrame != 0)) {
				this.currFrame += 1;
				this.lastTime = time;
			}

			if ((this.currFrame == this.finalFrame) && (this.loop)) {
				this.currFrame = this.initialFrame;
			} else if ((!this.loop) && (this.currFrame + 1 >= this.finalFrame)) {
				this.currFrame = (this.finalFrame - 1);
				this.playing = false;
			}
		}
	}

	public void stop() {
		this.currFrame = this.initialFrame;
		this.playing = false;
	}

	public void play() {
		this.playing = true;
	}

	public void pause() {
		this.playing = false;
	}

	public void setInitialFrame(int frame) {
		this.initialFrame = frame;
	}

	public int getInitialFrame() {
		return this.initialFrame;
	}

	public void setFinalFrame(int frame) {
		this.finalFrame = frame;
	}

	public int getFinalFrame() {
		return this.finalFrame;
	}

	public void setCurrFrame(int frame) {
		this.currFrame = frame;
	}

	public int getCurrFrame() {
		return this.currFrame;
	}

	public boolean isPlaying() {
		return this.playing;
	}

	public void hide() {
		this.drawable = false;
	}

	public void unhide() {
		this.drawable = true;
	}

	public void setLoop(boolean value) {
		this.loop = value;
	}

	public void draw() {
		if (this.drawable) {

			double rot = this.rotation;

			Graphics2D g2d = (Graphics2D) Window.getInstance().getGameGraphics();
			AffineTransform tx = new AffineTransform();

			tx.setToRotation(-rot, this.width / 2, this.height / 2);

			int newy = (int) (this.x * Math.sin(rot) + this.y * Math.cos(rot));
			int newx = (int) (this.x * Math.cos(rot) - this.y * Math.sin(rot));

			g2d.setTransform(tx);
			g2d.drawImage(this.image, newx, newy, newx + this.width, newy + this.height, this.currFrame * this.width, 0,
					(this.currFrame + 1) * this.width, this.height, null);
		}
	}
}
