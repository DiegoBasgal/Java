public class FuncaoAutenticacao {

    static public int funcaoRemDes(int nonce){
        return (nonce) * 3 / 2 + 2157;
    }

    static public int funcaoDesRem(int nonce) {
        return (nonce) + 1;
    }
}
