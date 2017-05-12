# 随机记录

## 探索编译执行

### 1
* `javac src/io/IOFile.java -d target` 编译IOFile.java文件到target目录下
* `cd target/` `java io.IOFile`执行class文件成功
### 2

## 探索vim使用

vim设置,文件路径为 /etc/vim/vimrc 或者在 ~/.vimrc 都行

### 个人配置文件记录

````rc
set nu "左侧显示行号"
set tabstop=2 "设置tabe缩进两个空格"
set nobackup "设置覆盖不备份"
set cursorline "设置突出显示当前行"
set ruler "右下角显示光标位置的状态行"
set autoindent "自动缩进"
set expandtab "设置使用空格代替tab
set softtabstop=2 "设置一次删除两个空格
set autochdir
set ignorecase "搜索时忽略大小写，但在有一个或以上大写字母时仍大小写敏感  
set hlsearch "设置搜索高亮
set nowrap "不自动换行
set laststatus=2 "显示状态栏
set showmatch "显示括号配对情况
set display=lastline "解决自动换行格式下, 如高度在折行之后超过窗口高度结果这一行看不到的问题
set statusline=\ %<%F[%1*%M%*%n%R%H]%=\ %y\ %0(%{&fileformat}\ [%{(&fenc==\"\"?&enc:&fenc).(&bomb?\",BOM\":\"\")}]\ %c:%l/%L%) "s设置状态行显示的信息
set list 
set listchars=tab:\|\ ,trail:.,extends:>,precedes:< "显示tab符号
set shortmess=atl "设置启动不显示捐赠提示

"blank      空白  
"buffers    缓冲区  
"curdir     当前目录  
"folds      折叠  
"help       帮助  
"options    选项  
"tabpages   选项卡  
"winsize    窗口大小  
"slash      转换文件路径中的\为/以使session文件兼容unix  
"unix       设置session文件中的换行模式为unix  
set sessionoptions=blank,buffers,curdir,folds,help,options,tabpages,winsize,slash,unix,resize
" 允许backspace和光标键跨越行边界  
set whichwrap+=<,>,h,l
" backspace  
set backspace=eol,start,indent

" 可以在buffer的任何地方使用鼠标（类似office中在工作区双击鼠标定位）  
set mouse=a  
set selection=exclusive  
set selectmode=mouse,key
" 在被分割的窗口间显示空白，便于阅读  
set fillchars=vert:\ ,stl:\ ,stlnc:\ 
"编码设置  
set enc=utf-8  
set fencs=utf-8,ucs-bom,shift-jis,gb18030,gbk,gb2312,cp936  
" set mapleader  
let mapleader="," 
" 插入模式下上下左右移动光标  
inoremap <c-h> <left>  
inoremap <c-l> <right>  
inoremap <c-j> <c-o>gj  
inoremap <c-k> <c-o>gk 
" 窗口切换  
nnoremap <c-h> <c-w>h  
nnoremap <c-l> <c-w>l  
nnoremap <c-j> <c-w>j  
nnoremap <c-k> <c-w>k  

````
暂时就是这样咯


