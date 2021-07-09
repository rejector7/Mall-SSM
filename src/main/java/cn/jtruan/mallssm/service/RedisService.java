package cn.jtruan.mallssm.service;

public interface RedisService {
    void set(String key, String value);

    String get(String key);

    void remove(String key);

    boolean expire(String key, long value);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
