package parser;

/**
 * @author  Santisco
 * @version 1.0
 * Opp_table為OPP算符优先关系表类
 *
 */
public class Opp_table {

	/**
	*在这二维关系表中,行     代表栈中数据,列    代表要读入的数据。即判断已读的和要读入的算符关系。
	*  0    代表压栈操作。
	*  1    代表一元操作,包括:~  sqrt sin cos。
	* -1   代表表达式有误。
	*  3    代表括号操作,包括函数的判断以及执行。
	*  4    代表接受状态 ,比较运算符优先级  (  二    元    操    作     )
	*  5    对于集合运算
	*  7.处理-- -+ +- ++
	*/

    static int table[][] = {
   /*      digit  +   -   *    /    pow  tan  cuberoot  fact  mod  sqrt  sin  cos   exp   (     )    #   yroot    ,   sum   [    ]   avg  varp  var    stdevp  stdev arcsin arccos arctan  sinh   cosh  tanh   ^    ln  log10 log*/
   /*digit*/{-1,  4,  4,  4,   4,   -1,  -1,   -1,       -1,   0,   -1,   -1,  -1,  -1,  -1,    3,   4,   -1,     4,  -1,  -1,   4,  -1,   -1,  -1,      -1,     -1,   -1,    -1,    -1,   -1,     -1,   -1,   4,   -1,   -1,  -1},
   /* + */  { 4,  7,  7, -1,  -1,    0,   0,    0,	      0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
   /*-*/    { 4,  7,  7, -1,  -1,    0,   0,    0,        0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
   /* * */  { 0, -1, -1, -1,  -1,    0,   0,    0,        0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
   /* / */  { 0, -1	,-1, -1,  -1,	 0,   0,	0,	      0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
   /* pow */{ 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,    0,   0,	 0,   0,   -1,  -1,    0,     0,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
   /* tan */{ 1, -1, -1, -1,  -1,	 0,	  0,    0,	      0,   0,    0,    0,   0	,0,   0,   -1,	-1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
/*cuberoot*/{ 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0  ,-1,   0,    0 ,   0 },
  /* fact */{ 1, -1, -1, -1,  -1,    0,	  0,	0,	      0,   0,	 0,	   0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0 ,   0,  -1,   0,    0,    0 },
   /* mod */{ 0, -1, -1, -1,  -1,	 0,   0,	0,	      0,   0,    0,    0,   0,	 0,   0,   -1,  -1,    0,     0,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },  
  /* sqrt */{ 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 } , 
   /* sin */{ 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,	   0,   0	,0,   0,   -1,	-1 ,   0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
   /* cos */{ 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,	   0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
   /* exp */{ 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   0,    0 ,  0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
     /* ( */{ 0,  0,  0,  0,   0,	 0,	  0,	0,	      0,   0,    0,    0,   0	,0,   0,   -1,	-1,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,   0,   0,    0,    0 },
     /* ) */{-1, -1, -1, -1,  -1,	-1,	 -1,   -1,       -1,  -1,   -1,	  -1,  -1,  -1,  -1,	0,  -1,   -1,    -1,  -1,  -1,  -1,  -1,   -1,  -1,      -1,     -1,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
     /* # */{ 0,  0,  0,  0,   0,	 0,   0,	0,	      0,   0,    0,	   0,   0,   0,   0,   -1,   4,    0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,   0,   0,    0,    0 },
   /*yroot*/{ 1, -1, -1, -1,  -1,	 0,   0,	0,	      0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,     0,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
     /* , */{ 0, -1,  0, -1,  -1,    0,   0,    0,        0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,     0,   0,   0,  -1,   5,    5,   5,       5,      5,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 } ,
  /*19sum*/ {-1, -1, -1, -1,  -1,	-1,  -1,   -1,       -1,  -1,   -1,   -1,  -1,  -1,   0,   -1,  -1,   -1,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
  /*20[*/   { 0, -1,  0, -1,  -1,    0,   0,    0,        0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,   0,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 } ,
  /*21]*/   { 0, -1, -1, -1,  -1,	-1,  -1,   -1	,    -1	, -1,   -1,   -1 , -1,  -1,  -1,	3,  -1,   -1,    -1,  -1,  -1,  -1,  -1,   -1,  -1,      -1,     -1,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
  /*avg*/   {-1, -1, -1, -1,  -1,	-1,  -1,   -1,       -1,  -1,   -1,   -1,  -1,  -1,   0,   -1,  -1,   -1,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
  /*varp*/  {-1, -1, -1, -1,  -1,	-1,  -1,   -1,       -1,  -1,   -1,   -1,  -1,  -1,   0,   -1,  -1,   -1,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
  /*var*/   {-1, -1, -1, -1,  -1,	-1,  -1,   -1,       -1,  -1,   -1,   -1,  -1,  -1,   0,   -1,  -1,   -1,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
/*stdevp*/{-1, -1, -1, -1,  -1,	-1,  -1,   -1,       -1,  -1,   -1,   -1,  -1,  -1,   0,   -1,  -1,   -1,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
  /*stdev*/ {-1, -1, -1, -1,  -1,	-1,  -1,   -1,       -1,  -1,   -1,   -1,  -1,  -1,   0,   -1,  -1,   -1,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
  /*arcsin*/{ 1, -1, -1, -1,  -1,	 0,   0,	0,        0,   0,    0,    0,   0	,0,   0,   -1,	-1 ,   0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0  },
  /*arccos*/{ 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,	   0,   0	,0,   0,   -1,	-1 ,   0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
  /*arctan*/{ 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,	   0,   0	,0,   0,   -1,	-1 ,   0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
  /*sinh*/  { 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,	   0,   0	,0,   0,   -1,	-1 ,   0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0 ,   0 },
  /*cosh*/  { 1 ,-1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,	   0,   0	,0,   0,   -1,	-1 ,   0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
  /*tanh*/  { 1, -1, -1, -1,  -1,	 0,	  0,	0,	      0,   0,    0,	   0,   0	,0,   0,   -1,	-1 ,   0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
  /*^*/     { 0, -1, -1, -1,  -1,    0,   0,    0,	      0,   0,    0,    0,   0,   0,   0,   -1,  -1,    0,    -1,   0,   0,  -1,   5,    5,   5,       5,      5,    0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
  /*ln*/    { 1, -1, -1, -1,  -1,	 0,   0,	0,	      0,   0,    0,	   0,   0	,0,   0,   -1,	-1 ,   0,    -1,   0,   0,  -1,   0,    0,   0,       0,      0 ,   0,     0,     0,    0,      0,    0,  -1,   0,    0,    0 },
 /*log10*/{-1, -1, -1, -1,  -1,	-1,	 -1,   -1,	     -1,  -1,   -1,	  -1,  -1,  -1,   0,   -1,	-1 ,  -1,    -1,  -1,  -1,  -1,  -1,   -1,  -1,      -1,     -1,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 },
  /*log*/   {-1, -1, -1, -1,  -1,	-1,	 -1,   -1,	     -1,  -1,   -1,	  -1,  -1  ,-1,   0,   -1,	-1 ,  -1,    -1,  -1,  -1,  -1,  -1,   -1,  -1,      -1,     -1,   -1,    -1,    -1,   -1,     -1,   -1,  -1,  -1,   -1,   -1 }
    };

    /**
     *在这二维关系表中,行     代表栈中数据,列     代表要读入的数据。即判断已读的和要读入的算符关系。
     *   0   代表出错。
     *   1   代表后入的操作符 优先级高,  压栈。
     *   -1  代表后入的操作符 优先级低,  规约表中操作
     *   6   代表规约成功，规约已完成
     *   2   处理正负号
     */
    static int table2[][] = {
   /*      digit  +   -  *   /   pow  tan  cuberoot  fact  mod  sqrt  sin   cos   exp  (    )   #  yroot  ,  sum  [   ]  avg  varp var stdevp stdev arcsin arccos arctan sinh  cosh tanh  ^  ln   log10  log */
   /*digit*/{ 1,  5,  5, 5,  5,   5,   5,    5,       5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5,     5 },
   /* + */  { 5, -1, -1, 1	,1	, 0	, -1,    0,       0,    1,   0,    0,    0,    0,  0,  -1, -1,   0,  -1, -1,  0, -1, -1,  -1,  -1,  -1,    -1,   -1,    -1,    -1,   -1,   -1,  -1,   1, -1,  -1,-1 },
   /*-*/    { 5	,-1, -1, 1	,1	, 0	, -1,    0,       0	,   1	,0	,  0	,0	,  0,  0,  -1, -1,   0,  -1, -1,  0, -1, -1,  -1,  -1,  -1,    -1,   -1,    -1,    -1,   -1,   -1,  -1,   1, -1,  -1,-1 },
   /* * */  { 5, -1, -1,-1, -1,   0,  -1,    0,       0,   -1,   0,    0,    0,    0,  0,  -1, -1,   0,  -1, -1,  0, -1, -1,  -1,  -1,  -1,    -1,   -1,    -1,    -1,   -1,   -1,  -1,   1, -1,  -1,-1 },
   /* / */  { 5, -1, -1,-1, -1,   0,  -1,    0,       0,   -1,   0,    0,    0,    0,  0,  -1, -1,   0,  -1, -1,  0, -1, -1,  -1,  -1,  -1,    -1,   -1,    -1,    -1,   -1,   -1,  -1,   1, -1,  -1,-1 },
    /*pow*/ { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    1,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /* tan */{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
/*cuberoot*/{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
  /* fact */{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
     /*mod*/{ 5, -1, -1,-1, -1	, 0	, -1,    0,       0,    1,   0,    0,    0,    0,  0,  -1, -1,   0,  -1, -1,  0, -1, -1,  -1,  -1,  -1,    -1,   -1,    -1,    -1,   -1,   -1,  -1,  -1, -1,  -1,-1 }, 
/* sqrt */  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 }, 
 /* sin */  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
 /* cos */  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
 /* exp */  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /* ( */  { 2,  1,  1, 1,  1,   0,   1,    0	,     0	,   1	,0,    0,    0,    0,  0,   0, -1,   0,   1,  1,  0,  0,  1,   1,   1,   1,     1,    1,     1,     1,    1,    1,   1,   1 , 1,   1, 1 },
   /* ) */  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5 ,  5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /* # */  { 2,  1,  1, 1,  1,   0,   1,    0	,     0	,   1	,0,    0,    0,    0,  0,   0,  6,   0,   1,  1,  0,  0,  1,   1,   1,   1,     1,    1,     1,     1,    1,    1,   1,   1,  1,   1, 1 },
   /*yroot*/{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    1,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /* , */  { 2,  1,  1, 1,  1,   0,   1,    0	,     0	,   1	,0,    0,    0,    0,  0,   0 , 0,   0,  -1,  1,  0,  1,  1,   1,   1,   1,     1,    1,     1,     1,    1,    1,   1,   1,  1,   1, 1 },
   /*sum*/  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 } ,
   /*[*/    { 2,  1,  1, 1,  1,   0,   1,    0	,     0	,   1	,0,    0,    0,    0,  0,   0,  0,   0,   1,  1,  1,  1,  1,   1,   1,   1,     1,    1,     1,     1,    1,    1,   1,   1,  1,   1, 1 },
   /*]*/    { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /*avg*/  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /*varp*/ { 5,  5,  5, 5,  5,   5,   5,    5	,     5	   ,5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /*var*/  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5 , 5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
  /*stdevp*/{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5 ,5 },
   /*stdev*/{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
  /*arcsin*/{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
  /*arccos*/{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5 ,  5, 5 },
  /*arctan*/{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
  /*sinh*/  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5 ,  5 ,  5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
  /*cosh*/  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },  
  /*tanh*/  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /*^*/    { 5, -1, -1,-1, -1	, 0	, -1,    0,       0,    1,   0,    0,    0,    0,  0,  -1, -1,   0,  -1, -1,  0, -1, -1,  -1,  -1,  -1,    -1,   -1,    -1,    -1,   -1,   -1,  -1,  -1, -1,  -1,-1 },
   /*ln*/   { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5 ,    5 ,   5,    5,   5,   5,  5,   5, 5 },
   /*log10*/{ 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 },
   /*log*/  { 5,  5,  5, 5,  5,   5,   5,    5	,     5	,   5	,5,    5,    5,    5,  5,   5,  5,   5,   5,  5,  5,  5,  5,   5,   5,   5,     5,    5,     5,     5,    5,    5,   5,   5,  5,   5, 5 }
    };


}