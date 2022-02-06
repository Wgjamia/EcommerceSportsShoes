package ly.algjamia.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ly.algjamia.model.SizeShoe;
import ly.algjamia.repository.SizeShoeRepository;


@Service
public class SizeShoeServiceImp implements SizeShoeService {

	@Autowired
	SizeShoeRepository shoeRepository;
	
	@Override
	public List<SizeShoe> getAllSizeShoe(String Keyword) {
		if (Keyword != null) {
			return shoeRepository.findByLikeSizeShoe(Keyword);
		}
			return (List<SizeShoe>) shoeRepository.findAll();
		
	}

	@Override
	public SizeShoe getSizeShoeById(Long id) {
		Optional<SizeShoe> optional = shoeRepository.findById(id);
		SizeShoe sizeShoe = null;
		if (optional.isPresent()) {
			sizeShoe = optional.get();
		} else {
			throw new RuntimeException("SizeShoe not found by ID " + id);
		}
		return  sizeShoe;
	}

	@Override
	public void addSizeShoe(SizeShoe sizeShoe) {
		shoeRepository.save(sizeShoe);
		
	}

	@Override
	public void deleteSizeShoe(Long id) {
		shoeRepository.deleteById(id);
		
	}

	@Override
	public SizeShoe findBySizeShoe(String sizeName) {
		return shoeRepository.findBySizeShoeName(sizeName);
	}

	
}