package ly.algjamia.services;

import java.util.List;
import ly.algjamia.model.SizeShoe;


public interface SizeShoeService {
	public List<SizeShoe> getAllSizeShoe(String Keyword);

	public SizeShoe getSizeShoeById(Long id);
	
	public void addSizeShoe(SizeShoe sizeShoe);
	
	public void deleteSizeShoe(Long id);
	
	public SizeShoe findBySizeShoe(String sizeName);

}
