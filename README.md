# study-scala
learn scala
github上传代码的默认分支由master变为了main。但本地分支仍旧为master，这就导致上传之后仓库有两个分支。不如直接把本地的分支也修改为main。

git checkout -b main 新建main分支，并转至main分支
git merge master 合并两个分支
然后就可以进行add，commit
git push -u origin main ，将本地main分支的推送至远程

