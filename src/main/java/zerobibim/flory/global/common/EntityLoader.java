package zerobibim.flory.global.common;

public interface EntityLoader<T, ID> {
    T loadEntity(ID id);
}
