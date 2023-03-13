package com.codecademy.boots.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.boots.enums.BootType;

public interface BootRepository extends CrudRepository<Boot,Integer> {
  public List<Boot> findBySize(Float size);
  public List<Boot> findBymaterial(String material);
  public List<Boot> findByType(BootType type);
  public List<Boot> findByQuantityGreaterThan(Inetger minQuantity);
  public List<Boot> findByMaterialAndQuantityGreaterThan(String material, Integer minQuantity);
  public List<Boot> findBymaterialAndSizeAndQuantityGreaterThan(Stirng materila, Float size, Integer minQuantity);
  public List<Boot> findByTypeAndSizeAndQuantityGreanterThan(BootType type, Float size, Integer minQuantity);
  public List<Boot> findByTypeAndQuantityGreaterThan(BootType type, Integer minQuantity);
}