package me.lukeforit.spaceofaday.data.source;

import java.util.List;

import io.reactivex.Single;
import me.lukeforit.spaceofaday.data.model.Apod;

public interface SpaceRepository extends ApodRepository {
    Single<List<Apod>> fetchAllApods();
}
