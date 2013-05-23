
public class Manager  implements EasyManager {

    public boolean transfer(EasyAccount[] accounts, int[] money) {
        for (int k = 0; k < accounts.length; k++) {
            while (true) {
                try {
                    accounts[k].change(money[k]);
                    break;
                } catch (TryAgainEx ignore) {
                    //NOP
                } catch (ZedDeadBabyEx rollback) {

                    for (int i = k - 1; i >= 0; i--) {
                        while (true) {
                            try {
                                accounts[i].change(-money[i]);
                                break;
                            } catch (TryAgainEx ignore) {
                                //NOP
                            } catch (ZedDeadBabyEx ignore) {
                                //NOP
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}

class TryAgainEx extends Exception {}

class ZedDeadBabyEx extends Exception {
    public ZedDeadBabyEx(String message) {
        super(message);
    }
}
 interface EasyManager {
    public boolean transfer(EasyAccount[] accounts, int[] money);
}

interface EasyAccount {
    public void change(int delta) throws TryAgainEx, ZedDeadBabyEx;
}