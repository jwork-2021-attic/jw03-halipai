# README

### 1.对代码工作原理的理解
首先在`SteganographyFactory.java`的`main`函数中执行`getSteganography`函数，将排序java文件写入图片中，生成新得到的图片
主要函数:
1.`SteganographyEncoder.java`中的`encodeFile`函数：用一套固定的方法将排序`.class`文件转换成字节数组bytes，具体方法为数组0-3个字节为文件名称所占的字节个数的二进制，4-7字节为文件所占的字节个数的二进制，然后依次为文件名称和文件内容，按照长度分配字节个数
2.`SteganographyEncoder.java`中的`encode`函数：首先按照要写入的照片的int大小定义一个int数组`pixel`，然后将bytes中的每一位字节都与mask及其他的参数一起经过一些计算方式得到的新字节一次放入`pixel`数组中，然后将原图片的`RGB`值加上`pixel`就得到了新的图片
这样，就可以在`Scene.java`中使用使用了隐写术的图片啦
在`Scene.java`中，`loader`读取了使用隐写术的图片

然后`c`运用隐写术解码的方法在`loader`中找到需要的排序函数名称，这个过程是上次课上讲的类加载，首先检查要找的类是否已经被加载到内存中，由于已经被我手动删除掉，所以已经没有了，然后从父类中加载，如果父类中也没有，则从`Bootstrap ClassLoader`中加载，如果也没有的话就使用`findclass`函数，由于函数在`SteganographyClassLoader.java`中被重写，所以依据源代码可以解码出要找的排序函数

然后找到排序函数的代码，最后`sorter`是`c`解码出来的排序函数，接下来的过程就与`W02`相同了

PS：无论升级到哪个版本都无法读取网络上的图片和本地绝对路径图片，只有在图片路径为本地相对路径的时候才能正常读出排序代码

### 2.两个排序算法的隐写术

原始图片：
![](https://github.com/halipai/MYIMAGES/raw/main/kuromi_melody/km0.jpeg?raw=true)

快速排序得到的图片的URL:
![](https://github.com/halipai/MYIMAGES/raw/main/java_W03/example.QSorter.png?raw=true)

选择排序得到的图片的URL:
![](https://github.com/halipai/MYIMAGES/raw/main/java_W03/example.SSorter.png?raw=true)

### 3.两个排序算法的排序动画

快速排序得到的动画：

[![asciicast](https://asciinema.org/a/440415.png)](https://asciinema.org/a/440415)

选择排序得到的动画：
[![asciicast](https://asciinema.org/a/440413.png)](https://asciinema.org/a/440413)


### 4.联系另一位同学

偷偷使用了@Roc136同学的图片`example.QuickSorter`和`example.SelectSorter`，在本地相对路径下能够成功运行

快速排序得到的动画：
[![asciicast](https://asciinema.org/a/440530.png)](https://asciinema.org/a/440530)


选择排序得到的动画
[![asciicast](https://asciinema.org/a/440529.png)](https://asciinema.org/a/440529)
