package hk.abitmoney.digicash;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private ImageView imView;
    private int page = 0;
    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    private int[] pages = new int[]{
            R.drawable.page1,
            R.drawable.page2,
            R.drawable.page3,
            R.drawable.page4,
            R.drawable.page5,
            R.drawable.page6,
            R.drawable.page7,
            R.drawable.page8
    };

    protected void onStart() {
        super.onStart();
        imView = (ImageView)findViewById(R.id.imageView);
        imView.setImageResource(R.drawable.page1);
        imView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int width = (int) view.getWidth();
                int height = (int) view.getHeight();
                int newPage = page;

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        switch(page) {
                            case 1: {
                                Rect button = new Rect(0, (int)(height/1.5), width, height);
                                if (button.contains(x, y)) {
                                    newPage = 2;
                                }
                                break;
                            }
                            case 2: {
                                Rect buttonPay = new Rect(0, (int)(height/2.2), width, (int)(height/1.8));
                                Rect buttonScan = new Rect(0, (int)(height/1.8), width/3, (int)(height/1.3));
                                Rect buttonMore = new Rect(width/3, (int)(height/1.8), width, (int)(height/1.3));
                                if (buttonPay.contains(x, y)) {
                                    newPage = 3;
                                }
                                if (buttonScan.contains(x, y)) {
                                    newPage = 4;
                                }
                                if (buttonMore.contains(x, y)) {
                                    newPage = 7;
                                }
                                break;
                            }
                            case 3: {
                                Rect buttonL = new Rect(0, (int)(height/1.3), width/2, height);
                                Rect buttonR = new Rect(width/2, (int)(height/1.2), width, height);
                                if (buttonL.contains(x, y)) {
                                    newPage = 2;
                                }
                                if (buttonR.contains(x, y)) {
                                    newPage = 5;
                                }
                                break;
                            }
                            case 4: {
                                Rect buttonL = new Rect(0, (int)(height/1.3), width/2, height);
                                Rect buttonR = new Rect(width/2, (int)(height/1.2), width, height);
                                if (buttonL.contains(x, y)) {
                                    newPage = 2;
                                }
                                if (buttonR.contains(x, y)) {
                                    newPage = 6;
                                }
                                break;
                            }
                            case 5: {
                                Rect buttonSend = new Rect(0, (int)(height/1.1), width, height);
                                if (buttonSend.contains(x, y)) {
                                    newPage = 2;
                                }
                                break;
                            }
                            case 6: {
                                Rect buttonL = new Rect(0, (int)(height/1.3), width/2, height);
                                Rect buttonR = new Rect(width/2, (int)(height/1.2), width, height);
                                if (buttonL.contains(x, y)) {
                                    newPage = 2;
                                }
                                if (buttonR.contains(x, y)) {
                                    newPage = 7;
                                }
                                break;
                            }
                            case 7: {
                                Rect buttonR = new Rect(width/2, (int)(height/1.2), width, height);
                                if (buttonR.contains(x, y)) {
                                    newPage = 2;
                                }
                                break;
                            }
                            default: {
                                newPage = (page +1) % pages.length;
                                break;
                            }
                        }
                }

                mPreviousX = x;
                mPreviousY = y;
                if (newPage != page) {
                    page = newPage;
                    imView.setImageResource(pages[newPage]);
                }
                return true;
            }
        });
//        imView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((BitmapDrawable)imView.getDrawable()).getBitmap().recycle();
//                imView.setImageResource(R.drawable.page1);
//                page = (page + 1) % 8;
//                switch (page) {
//                    case 1: imView.setImageResource(R.drawable.page1); break;
//                    case 2: imView.setImageResource(R.drawable.page2); break;
//                    case 3: imView.setImageResource(R.drawable.page3); break;
//                    case 4: imView.setImageResource(R.drawable.page4); break;
//                    case 5: imView.setImageResource(R.drawable.page5); break;
//                    case 6: imView.setImageResource(R.drawable.page6); break;
//                    case 7: imView.setImageResource(R.drawable.page7); break;
//                    case 8: imView.setImageResource(R.drawable.page8); break;
//
//                }
//            }
//        });
            // Set image
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
