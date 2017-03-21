package com.fulibaigong.tsai.ui;


import com.fulibaigong.tsai.SampleApplication.utils.LoadingDialogHandler;
import com.fulibaigong.tsai.SampleApplication.utils.SampleMath;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

import com.threed.jpct.Camera;
import com.threed.jpct.Config;
import com.threed.jpct.FrameBuffer;
import com.threed.jpct.Light;
import com.threed.jpct.Loader;
import com.threed.jpct.Object3D;
import com.threed.jpct.SimpleVector;
import com.threed.jpct.Texture;
import com.threed.jpct.TextureManager;
import com.threed.jpct.World;
import com.threed.jpct.util.MemoryHelper;
import com.vuforia.CameraCalibration;
import com.vuforia.Matrix44F;
import com.vuforia.Renderer;
import com.vuforia.State;
import com.vuforia.Tool;
import com.vuforia.Trackable;
import com.vuforia.TrackableResult;
import com.vuforia.Vec2F;
import com.vuforia.Vuforia;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


/**
 * Created by User on 2016/8/14.
 */
public class ImageTargetRenderer implements GLSurfaceView.Renderer
{
    private static final String LOGTAG = "ImageTargetRenderer";
    private SampleApplicationSession vuforiaAppSession;
    private ImageTargets mActivity;

    private Renderer mRenderer;
    boolean mIsActive = false;

    private World world;
    private Light sun;
    private Object3D cylinder;
    private Camera cam;
    private FrameBuffer fb;
    private float[] modelViewMat;
    private float fov;
    private float fovy;

    public ImageTargetRenderer(ImageTargets activity, SampleApplicationSession session) {
        mActivity = activity;
        vuforiaAppSession = session;
        world = new World();

        world.setAmbientLight(150,150, 150);
        world.setClippingPlanes(2.0f, 3000.0f);
        sun = new Light(world);

        sun.setIntensity(250, 250, 250);
        try{


            String ll;
            ll =  Integer.toString(ImageTargets.ff).trim()+"/leftleg.png";

            String rl;
            rl =  Integer.toString(ImageTargets.ff).trim()+"/rightleg.png";

            String lh;
            lh =  Integer.toString(ImageTargets.ff).trim()+"/left hand.png";

            String rh;
            rh =  Integer.toString(ImageTargets.ff).trim()+"/righthand.png";

            String bf;
            bf =  Integer.toString(ImageTargets.ff).trim()+"/body_front.png";

            String bb;
            bb =  Integer.toString(ImageTargets.ff).trim()+"/body_back.png";

            String bh;
            bh =  Integer.toString(ImageTargets.ff).trim()+"/body_head.png";

            TextureManager.getInstance().addTexture(
                    "ruler.png" ,
                    new Texture(mActivity.getAssets().open("ruler.png"))
            );

            TextureManager.getInstance().addTexture(
                    "weiqun_2.png",
                    new Texture(mActivity.getAssets().open("weiqun_2.png"))
            );

            TextureManager.getInstance().addTexture(
                    "leftleg.png",
                    new Texture(mActivity.getAssets().open(ll))
            );

            TextureManager.getInstance().addTexture(
                    "rightleg.png",
                    new Texture(mActivity.getAssets().open(rl))
            );

            TextureManager.getInstance().addTexture(
                    "left hand1.png",
                    new Texture(mActivity.getAssets().open(lh))
            );

            TextureManager.getInstance().addTexture(
                    "righthand1.png",
                    new Texture(mActivity.getAssets().open(rh))
            );

            TextureManager.getInstance().addTexture(
                    "body+front1.png",
                    new Texture(mActivity.getAssets().open(bf))
            );

            TextureManager.getInstance().addTexture(
                    "body_back_1.png",
                    new Texture(mActivity.getAssets().open(bb))
            );

            TextureManager.getInstance().addTexture(
                    "body_head_1.png",
                    new Texture(mActivity.getAssets().open(bh))
            );

            // loadOBJ 參數分別是：.obj, .mtl, 縮放大小
            String obj;
            String mtl;
           // obj = Integer.toString(ImageTargets.ff).trim() + "/1116.obj";
         //   mtl = Integer.toString(ImageTargets.ff).trim() + "/1116.mtl";
            Object3D[] tmp = Loader.loadOBJ(
                    mActivity.getAssets().open("1116.obj"),
                    mActivity.getAssets().open("1116.mtl"),
                    1
            );


            if(tmp != null && tmp.length >= 1){
                System.out.print("load");
                cylinder = tmp[0];
            }
            cylinder.strip();
            cylinder.build();
            cylinder.translate(0, 0, 0);
            cylinder.rotateX(0);
            cylinder.rotateY(0);
            cylinder.rotateZ(0);

            world.addObject(cylinder);
            cam = world.getCamera();

            SimpleVector sv = new SimpleVector();
            sv.set(cylinder.getTransformedCenter());
            sv.y -= 100;
            sv.z -= 100;
            sun.setPosition(sv);
        }catch(Exception e){
            e.printStackTrace();
        }
        MemoryHelper.compact();
    }

    /*   public ImageTargetRenderer(ImageTargets activity, SampleApplicationSession session) {
           mActivity = activity;
           vuforiaAppSession = session;

           world = new World();
           world.setAmbientLight(20, 20, 20);
           // set the following value according to your need, so the object won't be disappeared.
           world.setClippingPlanes(2.0f, 3000.0f);

           sun = new Light(world);
           sun.setIntensity(250, 250, 250);
           // Create a texture out of the icon...:-)
           if ( !TextureManager.getInstance().containsTexture("texture") ) {
               Texture texture = new Texture(BitmapHelper.rescale(BitmapHelper.convert(
                       mActivity.getResources().getDrawable(R.drawable.test2)), 64, 64));
               TextureManager.getInstance().addTexture("texture", texture);
           }

           cylinder = Primitives.getCone(10);
           cylinder.calcTextureWrapSpherical();
           cylinder.setTexture("texture");
           cylinder.strip();
           cylinder.build();

           // Transform (scale, rotate, translate) the object: Depends on your need.
   //    	cylinder.scale(scale);
           cylinder.rotateX(90.0f);
   //    	cylinder.rotateY(w); cylinder.rotateZ(w);
   //    	cylinder.translate(x, y, z);

           world.addObject(cylinder);

           cam = world.getCamera();

           SimpleVector sv = new SimpleVector();
           sv.set(cylinder.getTransformedCenter());
           sv.y -= 100;
           sv.z -= 100;
           sun.setPosition(sv);

           // for older Android versions, which had massive problems with garbage collection
           }catch(Exception e){
               e.printStackTrace();
           }
           MemoryHelper.compact();
       }
   */
    // Called to draw the current frame.
    @Override
    public void onDrawFrame(GL10 gl) {
        if (!mIsActive)
            return;

        // Call our function to render content
        renderFrame();

        updateCamera();
        world.renderScene(fb);
        world.draw(fb);
        fb.display();

    }


    // Called when the surface is created or recreated.
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.d(LOGTAG, "GLRenderer.onSurfaceCreated");

        initRendering(); // NOTE: Cocokin sama cpp - DONE

        // Call Vuforia function to (re)initialize rendering after first use
        // or after OpenGL ES context was lost (e.g. after onPause/onResume):
        vuforiaAppSession.onSurfaceCreated();
    }


    // Called when the surface changed size.
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Log.d(LOGTAG, "GLRenderer.onSurfaceChanged");

        if (fb != null) {
            fb.dispose();
        }
        fb = new FrameBuffer(width, height);
        Config.viewportOffsetAffectsRenderTarget = true;

        updateRendering(width, height);

        // Call Vuforia function to handle render surface size changes:
        vuforiaAppSession.onSurfaceChanged(width, height);
    }


    // Function for initializing the renderer.
    private void initRendering() {
        mRenderer = Renderer.getInstance();

        // Define clear color
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, Vuforia.requiresAlpha() ? 0.0f : 1.0f);

        // Hide the Loading Dialog
        mActivity.loadingDialogHandler
                .sendEmptyMessage(LoadingDialogHandler.HIDE_LOADING_DIALOG);
    }

    private void updateRendering(int width, int height) {

        // Update screen dimensions
        vuforiaAppSession.setmScreenWidth(width);
        vuforiaAppSession.setmScreenHeight(height);

        // Reconfigure the video background
        vuforiaAppSession.configureVideoBackground();

        CameraCalibration camCalibration = com.vuforia.CameraDevice.getInstance().getCameraCalibration();
        Vec2F size = camCalibration.getSize();
        Vec2F focalLength = camCalibration.getFocalLength();
        float fovyRadians = (float) (2 * Math.atan(0.5f * size.getData()[1] / focalLength.getData()[1]));
        float fovRadians = (float) (2 * Math.atan(0.5f * size.getData()[0] / focalLength.getData()[0]));

        if (vuforiaAppSession.mIsPortrait) {
            setFovy(fovRadians);
            setFov(fovyRadians);
        } else {
            setFov(fovRadians);
            setFovy(fovyRadians);
        }

    }

    // The render function.
    private void renderFrame() {
        // clear color and depth buffer
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        // get the state, and mark the beginning of a rendering section
        State state = mRenderer.begin();
        // explicitly render the video background
        mRenderer.drawVideoBackground();

        float[] modelviewArray = new float[16];
        // did we find any trackables this frame?
        for (int tIdx = 0; tIdx < state.getNumTrackableResults(); tIdx++) {
            // get the trackable
            TrackableResult result = state.getTrackableResult(tIdx);
            Trackable trackable = result.getTrackable();
            printUserData(trackable);

            Matrix44F modelViewMatrix = Tool.convertPose2GLMatrix(result.getPose());
            Matrix44F inverseMV = SampleMath.Matrix44FInverse(modelViewMatrix);
            Matrix44F invTranspMV = SampleMath.Matrix44FTranspose(inverseMV);

            modelviewArray = invTranspMV.getData();
            updateModelviewMatrix(modelviewArray);

        }
        // hide the objects when the targets are not detected
        if (state.getNumTrackableResults() == 0) {
            float m [] = {
                    1,0,0,0,
                    0,1,0,0,
                    0,0,1,0,
                    0,0,-10000,1
            };
            modelviewArray = m;
            updateModelviewMatrix(modelviewArray);
        }

        mRenderer.end();
    }


    private void printUserData(Trackable trackable) {
        String userData = (String) trackable.getUserData();
        String imagename = (String) trackable.getName();
        Log.d(LOGTAG, "UserData:Retreived User Data	\"" + userData + "\"");
        Log.d(LOGTAG, "UserData:Retreived User Data22	\"" + imagename + "\"");
    }

    private void updateModelviewMatrix(float mat[]) {
        modelViewMat = mat;
    }

    private void updateCamera() {
        if (modelViewMat != null) {
            float[] m = modelViewMat;

            final SimpleVector camUp;
            if (vuforiaAppSession.mIsPortrait) {
                camUp = new SimpleVector(-m[0], -m[1], -m[2]);
            } else {
                camUp = new SimpleVector(-m[4], -m[5], -m[6]);
            }

            final SimpleVector camDirection = new SimpleVector(m[8], m[9], m[10]);
            final SimpleVector camPosition = new SimpleVector(m[12], m[13], m[14]);

            cam.setOrientation(camDirection, camUp);
            cam.setPosition(camPosition);

            cam.setFOV(fov);
            cam.setYFOV(fovy);
        }
    }

    private void setFov(float fov) {
        this.fov = fov;
    }

    private void setFovy(float fovy) {
        this.fovy = fovy;
    }

}
