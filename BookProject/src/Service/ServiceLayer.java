package Service;

import DAO.UserDao;
import DTO.UserDto;

public class ServiceLayer {
	private static ServiceLayer serviceLayer = new ServiceLayer();

    private ServiceLayer() { }

    public UserDao dao = UserDao.getInstance();

    public static ServiceLayer getInstance() {
        return serviceLayer;
    }
    
    public boolean insert(UserDto userdto) {
        dao.insert(userdto);
        return true;
    }
}
