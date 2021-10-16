public final class Singleton {

    private static Singleton m_instance;
    private String m_Name;

    private Singleton(String name) {
        m_Name = name;
    }

    public String getName() {
        return m_Name;
    }

    public  static  Singleton getInstance(String name) {
        if (m_instance == null)
            m_instance = new Singleton(name);
        return m_instance;
    }
}

final class nonSynchronizedSingleton {
    private static nonSynchronizedSingleton m_instance;
    private String m_Name;

    private nonSynchronizedSingleton(String name) {
        m_Name = name;
    }
    public String getName() {
        return m_Name;
    }

    public  static nonSynchronizedSingleton getInstance(String name) {
        if (m_instance == null)
            m_instance = new nonSynchronizedSingleton(name);
        return m_instance;
    }
}

final class SynchronizedSingleton {

    private static SynchronizedSingleton m_instance;
    private String m_Name;

    private SynchronizedSingleton(String name) {
        m_Name = name;
    }
    public String getName() {
        return m_Name;
    }
    public static SynchronizedSingleton getInstance(String value) {
        synchronized (SynchronizedSingleton.class) {
            if (m_instance == null) {
                m_instance = new SynchronizedSingleton(value);
            }
            return m_instance;
        }
    }
}