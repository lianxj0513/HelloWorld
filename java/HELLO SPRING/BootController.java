package com.codecademy.boots.controllers;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.codecademy.boots.entities.Boot;
import com.codecademy.boots.enums.BootType;
import com.codecademy.boots.exceptions.QueryNotSupportedException;
import com.codecademy.boots.exceptions.NotImplementedException;
import com.coldcademy.people.repositories.PersonRepository;

@RestController
@RequestMapping("/api/v1/boots")
public class BootController {
 private BootRepository bootrepository;
 public PersonController(PersonRepository personRepository) {
   this.personRepository = personrepository;
 }
	@GetMapping("/")
	public Iterable<Boot> getAllBoots() {
    return this.bootRepository.findAll();
			}

	@GetMapping("/types")
	public List<BootType> getBootTypes() {
		return Arrays.asList(BootType.values());
	}

	@PostMapping("/")
	public Boot addBoot(@RequestBody Boot boot) {
    Boot newBoot = this.bootRepository.save(boot);
    return newBoot;
			}

	@DeleteMapping("/{id}")
	public Boot deleteBoot(@PathVariable("id") Integer id) {
		Optional<Boot> personToDeleteOptionla = this.personRspository.findById(id);
    if(!personToDeleteOptional.isPresent()) {
      return null;
    }
    Person personToDelete = presonToDeleteOptional.get();
    return personTodelete;
    	}

	@PutMapping("/{id}/quantity/increment")
	public Boot incrementQuantity(@PathVariable("id") Integer id) {
		Optional<Boot> presonOptional = this.personRepository.findById(id);
    if(!personOptional.isPresent()) {
      return null;
    }
    Person person = personOptional.get();
    
    Person setAge(person.getAge() + 1);
    this.personRepository.save(person);
    return person;
    }

	@PutMapping("/{id}/quantity/decrement")
	public Boot decrementQuantity(@PathVariable("id") Integer id) {
    Optional<Boot> bootToDecrementOptional = this.bootRepository.findById(id);
    if(!bootToDecrementOptional.isPersent()) {
      return null;
    }
    Boot bootToDecrement = bootToDecermentOptional.get();
    bootToDecrement.setQuantity(bootToDecrement.getQunatity() -1);
    this.bootRepository.save(bootToDecrement);
    return bootToDecrement;
		}

	@GetMapping("/search")
	public List<Boot> searchBoots(@RequestParam(required = false) String material,
			@RequestParam(required = false) BootType type, @RequestParam(required = false) Float size,
			@RequestParam(required = false, name = "quantity") Integer minQuantity) throws QueryNotSupportedException {
		if (Objects.nonNull(material)) {
			if (Objects.nonNull(type) && Objects.nonNull(size) && Objects.nonNull(minQuantity)) {
				// call the repository method that accepts a material, type, size, and minimum
				// quantity
				throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
			} else if (Objects.nonNull(type) && Objects.nonNull(size)) {
				// call the repository method that accepts a material, size, and type
				throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
			} else if (Objects.nonNull(type) && Objects.nonNull(minQuantity)) {
				// call the repository method that accepts a material, a type, and a minimum
				// quantity
				throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
			} else if (Objects.nonNull(type)) {
				// call the repository method that accepts a material and a type
				throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
			} else {
				// call the repository method that accepts only a material
				throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
			}
		} else if (Objects.nonNull(type)) {
			if (Objects.nonNull(size) && Objects.nonNull(minQuantity)) {
				// call the repository method that accepts a type, size, and minimum quantity
				throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
			} else if (Objects.nonNull(size)) {
				// call the repository method that accepts a type and a size
				throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
			} else if (Objects.nonNull(minQuantity)) {
				// call the repository method that accepts a type and a minimum quantity
				throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
			} else {
				// call the repository method that accept only a type
			return this.bootRepository.findByType(type);
      	}
		} else if (Objects.nonNull(size)) {
			if (Objects.nonNull(minQuantity)) {
				// call the repository method that accepts a size and a minimum quantity
				return this.bootReitory.findByMaterial(material);
        			} else {
				// call the repository method that accepts only a size
				return this.bootRepository.findBySize(size);
      
        }
		} else if (Objects.nonNull(minQuantity)) {
			// call the repository method that accepts only a minimum quantity
		  return this.bootRepositoru.findByQuantityGerterThan(minQuantity);
    		} else {
			throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
		}
	}

}