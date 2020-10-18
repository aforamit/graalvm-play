# graalvm-play

References:
https://www.graalvm.org/reference-manual/js/

## Commands
- Running Java (calling JS):

    --- Compile HelloPolyglot.java:
<code>
C:\Workshop\Development\graalvm-ce-java8-20.2.0\bin>javac C:\Workshop\Workspace\github\graalvm-play\src\HelloPolyglot.java
</code>

    --- Running HelloPolyglot.java:
<code>
C:\Workshop\Development\graalvm-ce-java8-20.2.0\bin>java -classpath C:\Workshop\Workspace\github\graalvm-play\src\ HelloPolyglot once "alpha=>beta" 212
</code>

- Running NodeJs (JS calling Java):
<code>
C:\Workshop\Workspace\github\graalvm-play>C:\Workshop\Development\graalvm-ce-java8-20.2.0\bin\node --jvm --vm.cp=src/ appjs2java.js
</code>
