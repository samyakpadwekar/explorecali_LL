package com.example.ec.repo;

import com.example.ec.domain.Tour;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


/**
 * Tour Repository Interface
 */
@Tag(name = "Tour Repo", description = "Tour API")
public interface TourRepository extends PagingAndSortingRepository<Tour, Integer>,CrudRepository<Tour, Integer> {
//public interface TourRepository extends JpaRepository<Tour, Integer> {	
	/**
     * Find Tours associated with the Tour Package.
     *
     * @param code tour package code
     * @return List of found tours.
     */
	//added paging
    Page<Tour> findByTourPackageCode(@Param("code")String code,Pageable pageable);
    
    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Tour tour);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
