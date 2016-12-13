
import java.lang.reflect.Field;


/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年11月3日 下午5:56:50 
 * @version 
 * @since  
 */
public class CpObjUnionAttribute {
	/**
	 * 将info对象与u对象相同类型的同名属性拷贝到u
	 * copy the same type and name attribute from object 'info' to object 'u'
	 * @param info
	 * @param u
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static <U extends Object,I extends Object> U getUsrUserByInsertReq(I info,U u) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object uObj = u;
		Object iObj = info;
		Field[] uFields = u.getClass().getDeclaredFields();
		Field[] infofields = info.getClass().getDeclaredFields();
		for(int i = 0; i < infofields.length; i++){
			for(int j = 0; j < uFields.length; j++){
				if(infofields[i].getName().equals(uFields[j].getName())){
					uFields[j].setAccessible(true);
					infofields[i].setAccessible(true);
					if(uFields[j].getGenericType() == infofields[i].getGenericType()){
						uFields[j].set(uObj, infofields[i].get(iObj));
					}
					System.out.println(uObj);
				}
			}
		}
		U uCopyFromInfo = (U) uObj;
		return uCopyFromInfo;
	}
}