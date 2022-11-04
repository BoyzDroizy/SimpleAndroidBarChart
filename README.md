<h1 align="center">SimpleAndroidBarChart</h1></br>

<p align="center">
:loudspeaker: SimpleAndroidBarChart is an Open Source Android library, that allows you to display a proposal of barchart. This is a simple example, for more customizations, you can download source code and custom it for your requirements.
</p><br>

<p align="center">
<img src="https://raw.githubusercontent.com/BoyzDroizy/SimpleAndroidBarChart/assets/images/BarChartGif.gif" width="50%"/>
</p>
</br>

## YouTube video
<a href="https://youtu.be/VmnQK9e56dY" 
target="_blank"><img src="https://img.youtube.com/vi/VmnQK9e56dY/1.jpg" 
alt="IMAGE ALT TEXT HERE" width="150" height="100" /></a> 

## Including in your project
[![](https://jitpack.io/v/BoyzDroizy/SimpleAndroidBarChart.svg)](https://jitpack.io/#BoyzDroizy/SimpleAndroidBarChart)
<a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
<a href="https://android-arsenal.com/api?level=26"><img alt="AxdroidX" src="https://img.shields.io/badge/AndroidX-1.0.0-brightgreen.svg?style=flat"/></a>
<a href="https://github.com/EusebiuCandrea/ToolTipPopupWordTV/blob/master/LICENSE"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
</p>

### Gradle 
Add below codes to your **root** `build.gradle` file.
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
And add a dependency code to your **module**'s `build.gradle` file.
```gradle
	dependencies {
	        implementation 'com.github.BoyzDroizy:SimpleAndroidBarChart:1.0.1'
	}
```

## Usage

### Basic Example (Kotlin)
Firstly, you need to add this custom text view to the layout of the class <br>

``` xml
    <com.boyzdroizy.simpleandroidbarchart.SimpleBarChart
        android:id="@+id/simpleBarChart"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```
In your class, using the 'id' from layout, call 'setChartData' method to give values for populate the chart.<br>

```kotlin
    val chartData = (12 downTo 1).map { Random.nextInt(10, 100) }.toMutableList()
    val intervalData = (12 downTo 1).map { it }.toMutableList()

    simpleBarChart.setChartData(chartData, intervalData)
    simpleBarChart.setMaxValue(max)
    simpleBarChart.setMinValue(0)
```

## Find this library useful? :heart:
Be free to use it and enjoy. :star:

# License
```xml
MIT License

Copyright (c) 2022 BoyzDroizy

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
