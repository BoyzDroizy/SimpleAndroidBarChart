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
	        implementation 'com.github.BoyzDroizy:SimpleAndroidBarChart:1.0'
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
 Copyright 2020

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
