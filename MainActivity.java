
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;

public class MainActivity extends Activity 
{
	private DrawView drawView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		drawView = new DrawView(this);
		drawView.setBackgroundColor(Color.WHITE);
		setContentView(drawView);
	}
}
class DrawView extends View {
	private Paint paint;
	private Path path;
	private float downx,downy;
	private float movex=0f,movey=0f;
	private void init() {
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		path = new Path();
	}

	public DrawView(Context context) {
		super(context);
		init();
	}

	public DrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public DrawView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	private Point start = new Point(400, 100);
	private Point control;
	private Point end = new Point(400, 1600);
	private float t=0.5f;
	private float radius=40f;
	private float segments=50;
	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		control = new Point((int)movex, (int)movey);
		paint.setColor(Color.RED);
		paint.setStrokeWidth(10);
		//path.moveTo(start.x,start.y);
		canvas.drawLine(
			start.x,start.y,
			control.x,control.y,
			paint
		);
		canvas.drawLine(
			control.x,control.y,
			end.x,end.y,
			paint
		);
		paint.setColor(Color.GREEN);
		canvas.drawLine(
			start.x,start.y,
			end.x,end.y,
			paint
		);
		paint.setColor(Color.WHITE);
		radius=40f;
		canvas.drawCircle(start.x,start.y,radius,paint);
		canvas.drawCircle(control.x,control.y,radius,paint);
		canvas.drawCircle(end.x,end.y,radius,paint);
		
		Point A=linearInterpolation(t,start,control);
		Point B=linearInterpolation(t,control,end);
		paint.setColor(Color.GRAY);
		radius=30f;
		canvas.drawCircle(A.x,A.y,radius,paint);
		canvas.drawCircle(B.x,B.y,radius,paint);

		paint.setColor(Color.GRAY);
		canvas.drawLine(
			A.x,A.y,
			B.x,B.y,
			paint
		);
		
		Point previousPoint=start;
		paint.setColor(Color.BLUE);
		
		for(float value=0;value<=segments;value++){
			float new_t =value/segments;
			Point P=quadraticInterpolation(new_t,start,control,end);
			
			canvas.drawLine(
				previousPoint.x,previousPoint.y,
				P.x,P.y,paint
			);
			previousPoint=P;
		}
		radius=20f;
		paint.setColor(Color.WHITE);
		Point P=quadraticInterpolation(t,start,control,end);
		
		canvas.drawCircle(P.x,P.y,radius,paint);
	}
	// Quadratic interpolation
	public Point quadraticInterpolation(
		float t,
		Point start,
		Point control,
		Point end
	){
		Point A=linearInterpolation(t,start,control);
		Point B=linearInterpolation(t,control,end);
		Point P=linearInterpolation(t,A,B);
		return P;
	}
	// Linear interpolation
	public Point linearInterpolation(
		float t,
		Point start, 
		Point stop
	){
		float Px=(1-t)*start.x+t*stop.x;
		float Py=(1-t)*start.y+t*stop.y;
		Point P = new Point(
			(int)Px,
			(int)Py
		);
		return P;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		switch(event.getAction()){
			case event.ACTION_DOWN:
				downx=event.getX();
				downy=event.getY();
				if(false){
					
				}
				break;
			case event.ACTION_MOVE:
				movex=event.getX();
				movey=event.getY();
				invalidate();
				break;
		}
		return true;
	}
	
}
