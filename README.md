# <img src="http://ww2.sinaimg.cn/large/005Xtdi2jw1f2jqaxc47fj3074074mxf.jpg" width=32 /> Statelayout

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![](https://jitpack.io/v/sushanqiang/StatelayoutLibrary.svg)](https://jitpack.io/#sushanqiang/StatelayoutLibrary)

## Statelayout 界面状态类
### 作者博客: [@wsdbssxq](http://blog.csdn.net/wsdbssxq?viewmode=contents)

####在app使用中会经常切换界面状态，比如，加载中，加载失败，网络错误等等，所以封装了一个工具类。

###截图：

<img src=" https://github.com/sushanqiang/StatelayoutLibrary/blob/master/img/Screenshot_20170420-155733.png" width=300 height=500 />

<img src="https://github.com/sushanqiang/StatelayoutLibrary/blob/master/img/Screenshot_20170420-155743.png" width=300 height=500 />


# 如何添加
### Gradle
#### 1.在Project的build.gradle 中添加仓库地址
``` gradle
 // JitPack仓库地址
 maven { url "https://jitpack.io" }
```

示例：
``` gradle
allprojects {
    repositories {
        jcenter()
        // JitPack仓库地址
        maven { url "https://jitpack.io" }
    }
}
```
#### 2.在Module目录下的build.gradle中添加依赖
```gradle
  //添加依赖
    compile 'com.github.sushanqiang:StatelayoutLibrary:v1.0.0'
```

示例:
 ``` gradle
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:25.1.0'
    //添加依赖
    compile 'com.github.sushanqiang:StatelayoutLibrary:v1.0.0'
}
```
 
## 版本更新：
版本号 | 更新内容
:-----:| ------------
v1.0.0 | 创建statelayout,让界面状态变得更加容易操作。
 



## About Me

<a href="http://blog.csdn.net/wsdbssxq?viewmode=contents" target="_blank"> <img src="http://avatar.csdn.net/C/5/3/1_wsdbssxq.jpg" width=300 height=100 /> </a>

# License
```
Copyright (c) 2016 GcsSloop

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

