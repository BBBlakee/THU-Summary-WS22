---
title: Mobile Application Development
---

## Questions in the exam

multiple choice questions, naming, explaining, analyzing/writing source code

### General

- Know concepts, names. Be able to explain these as precise as possible.
- Be able to explain every kind of code on the topics from this course.
- Be able to write simple code. However, I do not expect you to be able to write code
for complex API’s on paper (e.g. for creating notifications, exact source code for
custom adapters...).
- Refresh your knowledge how you realized various aspects of the projects “Currency
Converter”, “Compass” and “MAD Music Player”

## Question Collection

### Overview: Mobile Computing

- **Which kinds of mobility can be distinguished in Mobile Computing?**
  - Device mobility - mobile and networked
  - User mobility - user is mobile and uses different devices
  - Service mobility - service is available everywhere and anytime
- **What does the term “convergence” mean?**
  - mobile and stationary devices become increasingly similar
- **Name 5 different mobile operating systems!**
  - iOS
  - Android
  - Windows Phone/Windows 10 Mobile
  - Blackberry OS
  - Firefox OS
  - (future) Fuchsia
- **From a business perspective, does it make sense to always focus on
developing for the platform(s) with the largest market share?**
  - No, because the market share is not the only important factor. Other factors
    are the target group, the development costs, the time to market, the
      development skills, the market share of the competitors, etc.
- **Compared to developing desktop applications, what are special aspects of
developing mobile applications? Name 5!**
  - limited screen size, touch gestures
  - usage is often not continuous
  - less resources available
  - power dissipation is important
  - potentially slower network connection
  - many sensors available
- **During lecture, you encountered two fundamental approaches to app
development. Name them and discuss the differences!**
  - Native Development Tools (or Native SDKs)
    - Pros: full access to all features of the device, high performance
    - Cons: development for each platform separately, high development costs
  - Cross-Platform Development Tools
    - pros: development for multiple platforms with one code base, low development costs
    - cons: limited access to device features, lower performance

### First Steps

- **Shown is the Android architecture (F2.7). Briefly explain or name the 6
different areas!**
  - System Apps (Dialer, Email, Browser, etc.)
  - Java API Framework (Content Providers, View System, Managers, etc.)
  - Native Libraries (C/C++ Libraries)
  - Android Runtime (ART, Core Libraries)
  - Hardware Abstraction Layer (HAL) (Audio, Sensors, etc.)
  - Linux Kernel (Drivers, Power Management, etc.)
- **What do the terms “Minimum SDK” and “Target SDK” mean for an Android
project?**
  - Minimum SDK: the lowest Android version that is supported by the app
  - Target SDK: the Android version that the app is developed for
- **How can you make an Android device ready to use for development?**
  - Activate Developer Options
  - Connect the device to the computer
  - Allow USB debugging
- **What is an activity?**
  - App component that is responsible for a single screen with a user interface
  - can start other activities
  - <-- returns to the previous activity
- **Given a basic project structure (AndroidManifest.xml, res/activity_main.xml)
give an implementation for the activity MainActivity that shows the layout!**

```java
package com.example.ZSF;
import ...;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

- **How can you add an event handler to a button? (describe with source code or
natural language)**
  - add an onClick attribute to the button in the layout and create the method
  - set an onClickListener in the activity

```java
Button button = (Button) findViewById(R.id.button);
button.setOnClickListener(v -> {
            (// do something)
        });
```

- **How can you find a View from your layout to access its properties / call
methods? (source code AND explanation)**
- Search for the View in the `R` class (e.g. `R.id.button`)

```java
Button button = (Button) findViewById(R.id.button); // cast is unnecessary
```

### App Contents / UI

- **Given an AndroidManifest.xml explain its elements! (application, usespermission,
activity, intent-filter, service…)**
  - Declares information about the app and its services
  - Required permissions ```<uses-permission android:name="android.permission.CALL_PHONE/>```
  - SDK version ```<uses-sdk android:minSdkVersion="15" android:targetSdkVersion="25"/>```
  - All activities ```<activity android:name=".MainActivity">```
  - Services ```<service android:name=".MyService"/>```
  - Broadcast receivers ```<receiver android:name=".MyReceiver"/>```
  - Content providers ```<provider android:name=".MyProvider"/>```
- **Why do we have to declare required permissions in our manifest?**
  - The user has to explicitly grant the permission
- **How did the handling of permissions change with Android 6.0 (API level 23)?
(Moodle FAQ)**
  - Originally had to be granted by the user on installation
  - Since Android 6.0, the user has to grant permissions at runtime
- **What is the “Back-Stack”?**
  - Stack (last in first out) of the past sequence of Activities
- **How is the relationship between View and ViewGroup? Name an example
concrete class for each!**
  - View: a single UI element (e.g. Button, TextView, ImageView)
  - ViewGroup: a container for other Views (e.g. LinearLayout, RelativeLayout)
- **Name 3 rules for creating good mobile user interfaces from a user experience
point of view!**
  - Don't clutter screens: One Activitry per screen
  - Easy to understand arragements
  - Intuitive usability
  - perform longer running tasks in the background
  - standard keys keep their standard functions
  - no special menu entry "Exit App"
- **How can you connect a ListView with its data?**
  - Use an Adapter (e.g. ArrayAdapter)
- **What do you have to provide to an ArrayAdapter when creating it (in natural
language, exact parameter order not relevant)**
  - Context (Activity), Layout ressource, Array with data, id of the TextView
- **When will an ArrayAdapter not be enough, meaning you have to implement a
custom adapter class?**
  - If you want to display more than one View per item
  - Use a different layout
- **Given a custom adapter class (like F3.36), explain what happens inmethod
getView()!**
  - gets data element at position ``i``
  - Creates view, reuses existing view when provided to the method
  - Fills view with data

```java
public View getView(int i, View view, ViewGroup viewGroup) {
    if (view == null) {
        view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }
    TextView textView = (TextView) view.findViewById(R.id.textView);
    textView.setText(data[i]);
    return view;
}
```

### Ressources / Event Handling / Toolbars

- **What is a resource qualifier? Name 3 examples!**
  - Language
  - Region
  - Orientation
  - Resolution, display density
  - day/night
- **How can you access a resource from within your application?**
  - f.e. ```R.string.app_name``` or ```R.drawable.ic_launcher```
- **Which view can be used to show a picture?**
  - ``ImageView``
- **How can you create a multilingual app for Android?**
  - Use ``strings.xml`` for each language with different language qualifiers
- **Which basic steps do have to take if you want to add a toolbar menu/icons to
your app? (only basic steps!)**
  - Remove standard title bar in the manifest ``android:theme="@style/Theme.AppCompat.Light.NoActionBar">``
  - Add toolbar to the layout
  - Set default toolbar in onCreate

```java
Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
```
