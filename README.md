<html>

<body>
<p>一份有关于科学计算器的简介，用于东北大学的课程设计。<br></p>
<p><h2>可以实现的功能：</h2></p>
<hr />
<p><b><li>基本的计数器运算。</p>
<p><li>科学计算器运算。</p>
<p><li>手动输入的计算器运算。</p>
<p><li>基于JavaFX的UI部分设计。<br><br><br></b></p>
</body>

<body>
<p><h2>基本的实现机理：</h2></p>
<hr />
<p><b><li>UI部分运用传统的MVC模式，由于Model部分数据较多，就将view与controller同时放在gui包中，其中皮肤文件是在skin.css文件中；算法部分实现模式勉强算是工厂模式，利用词法与语法分析功能实现对输入串的分析以及操作。<br><br><br></b></p>
</body>

<body>
<p><h2>仍存在的问题：</h2><p>
<hr />
<p><b><li>时间紧迫，代码冗余量较大，没能代码重构很可惜。</p>
<p><li>由于图片不足，Button的字符都是手动输入，可能出现乱码以及UI不美观。<br><br><br></p>
</body>

<body>
<p><h2>程序基本截图：</h2></p>
<hr />
![printShot](https://github.com/Santisco/ScientificCalculator/raw/master/printShot.png)
</body>
</html>