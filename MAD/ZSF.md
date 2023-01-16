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

