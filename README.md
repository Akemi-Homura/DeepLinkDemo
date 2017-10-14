# Android Link跳转调研

#### 测试URL
- [myscheme://www.fristactivity.com](myscheme://www.fristactivity.com)
- [myscheme://www.secondactivity.com](myscheme://www.secondactivity.com)
- [myscheme://www.thirdactivity.com](myscheme://www.thirdactivity.com)
- [myscheme://www.fourthactivity.com](myscheme://www.fourthactivity.com)
- [myscheme://www.fifthactivity.com](myscheme://www.fifthactivity.com)



#### 方案一：Scheme跳转

- 在Manifest中加入

    <intent-filter>
      <action android:name="android.intent.action.VIEW"/>

      <category android:name="android.intent.category.DEFAULT"/>
      <category android:name="android.intent.category.BROWSABLE"/>

      <data
            android:host="www.targetapp.com"
            android:scheme="http"/>
    </intent-filter>

	data 中的scheme必选

- 在内置浏览器或任意地方进行URL 跳转即可（如任意APP中的TextView）
- 在被唤醒的Activity中的onCreate()方法中使用getIntent()即可获取到URL的信息
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Intent intent = getIntent();

      Log.e(TAG, "scheme:" + intent.getScheme());
      Uri uri = intent.getData();
      if (uri == null) {
        return;
      }
      ((TextView) findViewById(R.id.info)).setText(uri.toString());
      Log.e(TAG, "scheme: " + uri.getScheme());
      Log.e(TAG, "host: " + uri.getHost());
      Log.e(TAG, "port: " + uri.getPort());
      Log.e(TAG, "path: " + uri.getPath());
      Log.e(TAG, "queryString: " + uri.getQuery());
      Log.e(TAG, "queryParameter: " + uri.getQueryParameter("func"));

    }
```
难点

- 如何跳转到指定函数？<br/>
  解析Intent中的信息来确定要执行的函数
- 如何封装成SDK？<br/>
  使用反射
- 如何拦截Intent？<br/>
  Hook技术

#### 方案二：
