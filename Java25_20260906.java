public record Java25_20260906(){
    /**
     * Java25は、main()にstaticが不要<p>
     * Java 11以降は、単体クラスに限っては、実行前のコンパイルコマンド不要
     */
    public void main(){
        IO.println("main method works without static");
    }
}