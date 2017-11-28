package org.park.javadesignpattern.vvday.Interpreter.example;

import java.awt.*;



public class VV_TurtleCanvas extends Canvas implements VV_ExecutorFactory {
	final static int UNIT_LENGTH = 30;				// 움직일 때의 단위 길이
	final static int DIRECTION_UP = 0;				// 위쪽 방향
	final static int DIRECTION_RIGHT = 3;			// 오른쪽 방향
	final static int DIRECTION_DOWN = 6;			// 아래쪽 방향
	final static int DIRECTION_LEFT = 9;			// 왼쪽 방향
	final static int RELATIVE_DIRECTION_RIGHT = 3; 	// 오른쪽으로 향하다.
	final static int RELATIVE_DIRECTION_LEFT = -3;	// 왼쪽으로 향하다.
	final static int RADIUS = 3;					// 반지름
	private int direction = 0;
	private Point position;
	private VV_Executor executor;
	public VV_TurtleCanvas(int width, int height) {
		setSize(width, height);
		initialize();
	}
	public void setExecutor(VV_Executor executor){
		this.executor = executor;
	}
	void setRelativeDirection(int relativeDirection){
		setDirection(direction + relativeDirection);
	}
	void setDirection(int direction){
		if(direction < 0){
			direction = 12 - (-direction) % 12;
		} else{
			direction = direction % 12;
		}
		this.direction = direction % 12;
	}
	
	void go(int length){
		int newx = position.x;
		int newy = position.y;
		switch (direction) {
		case DIRECTION_UP:
			newy -= length;
			break;
		case DIRECTION_RIGHT:
			newx += length;
			break;
		case DIRECTION_DOWN:
			newy += length;
			break;
		case DIRECTION_LEFT:
			newx -= length;
			break;
		default:
			break;
		}
		Graphics g = getGraphics();
		if (g != null){
			g.drawLine(position.x, position.y, newx, newy);
			g.fillOval(newx-RADIUS, newy-RADIUS, RADIUS*2+1, RADIUS*2+1);
		}
		position.x = newx;
		position.y = newy;
	}

	@Override
	public VV_Executor createExecutor(String name) {
		if(name.equals("go")){
			return new VV_GoExecutor(this);
		}else if(name.equals("right")){
			return new DirectionExecutor(this, RELATIVE_DIRECTION_RIGHT);
		}else if(name.equals("left")){

			return new DirectionExecutor(this, RELATIVE_DIRECTION_LEFT);
		}else{
			return null;
		}
	}
	
	public void initialize(){
		Dimension size = getSize();
		position =  new Point(size.width / 2, size.height / 2);
		direction = 0;
		setForeground(Color.red);
		setBackground(Color.white);
		Graphics g = getGraphics();
		if(g != null){
			g.clearRect(0, 0, size.width, size.height);
		}
	}
	public void paint(Graphics g){
		initialize();
		if(executor != null){
			try{
				executor.execute();
			}catch(VV_ExecuteException e){}
		}
	}
	
	abstract class VV_TurtleExecutor implements VV_Executor{
		protected VV_TurtleCanvas canvas;
		public VV_TurtleExecutor(VV_TurtleCanvas canvas){
			this.canvas = canvas;
		}
	}
	
	class VV_GoExecutor extends VV_TurtleExecutor{
		public VV_GoExecutor(VV_TurtleCanvas canvas){
			super(canvas);
		}

		@Override
		public void execute() throws VV_ExecuteException {
			canvas.go(VV_TurtleCanvas.UNIT_LENGTH);
			
		}
	}
	
	class DirectionExecutor extends VV_TurtleExecutor{
		private int relativeDirection;
		public DirectionExecutor(VV_TurtleCanvas canvas, int relativeDirection) {
			super(canvas);
			this.relativeDirection = relativeDirection;
		}
		
		@Override
		public void execute() throws VV_ExecuteException {
			canvas.setRelativeDirection(relativeDirection);
			
		}
		
	}

}
