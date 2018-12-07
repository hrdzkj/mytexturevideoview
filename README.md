TextureView的用法
1. TextureView 预览摄像头；TextureView进行播放
2。MediaController的用法
TextureVideoView是国外https://sprylab.com/en/home.html 网站的公司做出的第三方库。

待上传github: texturevideoview.


vlc播放音频
/Applications/VLC.app/Contents/MacOS/VLC --demux=rawaud --rawaud-channels 1 --rawaud-samplerate 8000 /Users/mac/Desktop/encode_mono_pcm.pcm



在Android 4.1以前，Android并没有提供硬编硬解的API.
可以直接使用MediaRecord来进行录像，但是在很多适合MediaRecord并不能满足我们的需求，
比如我们需要对录制的视频加水印或者其他处理后，所有的平台都按照同一的大小传输到服务器等。
ndk安装
版本

as_aac_codec_fdk：音频原始数据pcm和压缩数据格式aac间的转换编解码：音频原始数据pcm和压缩数据式压缩。
                  使用到的库：Fdk-aac
                  如果是pcm<--->mp3间进行编解码，请看《音视频开发进阶》2.3.4 使用LAME编码MP3文件。

Android-as_video_recorder: 用到了ffmepg,x264,fdk.集成程度较高。
                           包括了视频的采集NV21,MediaCodec(硬)/x264(软)编码,egl渲染。
                           结合《音视频开发进阶》第6章 音视频的采集与编码 来看。

Android-OpenGLRenderer： openGL进行渲染
Android-FFmpegDecoder： 使用FFmpeg进行解码
Android-as_video_player/Android-live_video_player：实现的一个播放器（c++，ffmpeg）
Android-Mp3Encoder：mp3编码（应该是书上的例子）
Android-AudioRecorder：音频录制
Android-AudioPlayer：音频播放
cross_compile_project： ffmpeg在android,windows,ios三个平台的编译流程
对音视频的学习思路：https://blog.csdn.net/sinat_31057219/article/details/79521374
采集-->编解码-->渲染-->封装-->串联
-->高级特性（剪裁、旋转、水印、滤镜，并学习 OpenGL 高级特性，如：VBO，VAO，FBO）
-->网络协议
-->学习开源项目（如 webrtc，ffmpeg，ijkplayer，librtmp 等等）
-->移植到android平台（ffmpeg，x264，librtmp）
-->

有一些是同一个项目是eclipse版本，同时有as版本的，就不写上了。

AudioRecord和MediaRecorder两种都可以录制音频，MediaRecorder已实现大量的封装，操作起来更加简单，而AudioRecord使用起来更加灵活，能实现更多的功能。

1.AudioRecord(基于字节流录音) 
优点：可以实现语音的实时处理，进行边录边播，对音频的实时处理。 
缺点：输出的是PCM的语音数据，如果保存成音频文件是不能被播放器播放的。要用到AudioTrack这个去进行处理。

2.MediaRecorder(基于文件录音) 
已集成了录音，编码，压缩等，支持少量的音频格式文件。 
优点：封装度很高，操作简单 
缺点：无法实现实时处理音频，输出的音频格式少。

功能实现：MediaRecorder（这里需要注意，无论录制还是播放都是一个耗时操作，需要在非主线程中去操作）

