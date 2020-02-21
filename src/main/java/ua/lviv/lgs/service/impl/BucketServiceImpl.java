package ua.lviv.lgs.service.impl;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.repository.BucketRepository;
import ua.lviv.lgs.repository.impl.BucketRepositoryImpl;
import ua.lviv.lgs.service.BucketService;

import java.util.List;

public class BucketServiceImpl implements BucketService {

    private BucketRepository bucketRepository;

    public BucketServiceImpl() {
        this.bucketRepository = new BucketRepositoryImpl();
    }

    @Override
    public Bucket save(Bucket bucket) {
        return null;
    }

    @Override
    public Bucket findById(Integer id) {
        return null;
    }

    @Override
    public Bucket update(Bucket bucket) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Bucket> findAll() {
        return null;
    }
}
