package com.lrn.adapter.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lrn.adapter.ISiteAdapter;
import com.lrn.dto.LanguageDTO;
import com.lrn.dto.LanguagesDTO;
import com.lrn.dto.RsaKeysDTO;
import com.lrn.dto.SiteConfigsDTO;
import com.lrn.dto.SiteUserQueryResponseDTO;
import com.lrn.dto.UserDTO;
import com.lrn.dto.UserLabelsDTO;
import com.lrn.dto.course.CourseLookupsDTO;
import com.lrn.dto.response.site.SiteBrandingDTO;
import com.lrn.dto.response.site.SiteInfoDTO;
import com.lrn.dto.response.site.SiteSettingsDTO;
import com.lrn.dto.response.site.SiteUsersDTO;
import com.lrn.manager.IRsaKeysManager;
import com.lrn.manager.course.IAssetManager;
import com.lrn.manager.custom.ICustomSectionsManager;
import com.lrn.manager.site.ISiteConfigsManager;
import com.lrn.manager.site.ISiteManager;
import com.lrn.manager.site.ISiteSettingsManager;
import com.lrn.model.hibernate.RsaKeys;
import com.lrn.model.hibernate.custom.CustomSections;
import com.lrn.model.hibernate.site.Site;
import com.lrn.model.hibernate.site.SiteConfigs;
import com.lrn.model.hibernate.site.SiteConfigsPK;
import com.lrn.model.hibernate.site.SiteSettings;
import com.lrn.model.lcec.Language;


/**
 * The Class SiteAdapter.
 */
public class SiteAdapter implements ISiteAdapter {

	private static final Logger logger = Logger.getLogger(SiteAdapter.class);
	
	private ISiteManager 			siteManager;
		
	private ISiteSettingsManager 	siteSettingsManager;
	
	private ICustomSectionsManager customSectionsManager;
	
	private ISiteConfigsManager siteConfigsManager;
	
	private IRsaKeysManager rsaKeysManager;
	
	private IAssetManager assetManager;
	
	private String environmentName;	
	
	/**
	 * @param siteManager the siteManager to set
	 */
	public void setSiteManager(ISiteManager siteManager) {
		this.siteManager = siteManager;
	}

	/**
	 * @param siteSettingsManager the siteSettingsManager to set
	 */
	public void setSiteSettingsManager(ISiteSettingsManager siteSettingsManager) {
		this.siteSettingsManager = siteSettingsManager;
	}
	
	public void setCustomSectionsManager(ICustomSectionsManager customSectionsManager) {
		this.customSectionsManager = customSectionsManager;
	}
	
	public void setSiteConfigsManager(ISiteConfigsManager siteConfigsManager) {
		this.siteConfigsManager = siteConfigsManager;
	}

	public IRsaKeysManager getRsaKeysManager() {
		return rsaKeysManager;
	}

	public void setRsaKeysManager(IRsaKeysManager rsaKeysManager) {
		this.rsaKeysManager = rsaKeysManager;
	}

	public void setAssetManager(IAssetManager assetManager) {
		this.assetManager = assetManager;
	}

	@Override
	public SiteInfoDTO getInfo(Long siteId) {
		//TODO : Need to work on Exception throwing
		Site site = siteManager.get(siteId);
		SiteInfoDTO siteInfoDTO = getSiteInfoDTO(site);
		return siteInfoDTO;
	}

	@Override
	public Long getSite(String name) {
		//TODO : Need to work on Exception throwing
		Site site = siteManager.getSiteByName(name);
		return site.getId();
	}

	@Override
	public SiteUsersDTO getSiteUsers(Long siteId) {
		//TODO : Need to work on Exception throwing
		SiteUsersDTO siteUsersDTO = new SiteUsersDTO();
		siteUsersDTO.setSiteId(siteId);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		List<SiteUserQueryResponseDTO> queryResponses = siteManager.getSiteUserQueryResponseDTO(siteId);
		for(SiteUserQueryResponseDTO queryResponse : queryResponses) {
			userDTOs.add(getUserDTO(queryResponse));
		}
		siteUsersDTO.setUsers(userDTOs);
		return siteUsersDTO;
	}

	@Override
	public SiteUsersDTO getSiteUsersByUserIds(Long siteId, List<String> userIds) {
		//TODO : Need to work on Exception throwing
		SiteUsersDTO siteUsersDTO = new SiteUsersDTO();
		siteUsersDTO.setSiteId(siteId);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		List<SiteUserQueryResponseDTO> queryResponses = 
			siteManager.getSiteInUsersQueryResponseDTO(siteId, userIds);
		for(SiteUserQueryResponseDTO queryResponse : queryResponses) {
			userDTOs.add(getUserDTO(queryResponse));
		}
		siteUsersDTO.setUsers(userDTOs);
		return siteUsersDTO;
	}
	
	@Override
	public SiteSettingsDTO getSiteSettingByCompanyAndSettingName(String company, 
			String settingName) {
		SiteSettings siteSettings = 
			siteSettingsManager.getByCompanyNameSettingName(company, settingName);
		return getSiteSettingsDTO(siteSettings);
	}

	/**
	 * Constructs SiteSettingsDTO
	 *
	 * @param SiteSettings siteSettings
	 * 
	 * @return SiteSettingsDTO
	 */
	private SiteSettingsDTO getSiteSettingsDTO(SiteSettings siteSettings) {
		SiteSettingsDTO siteSettingsDTO = new SiteSettingsDTO();
		siteSettingsDTO.setCompany(siteSettings.getSiteSettingsPK().getCompany());
		siteSettingsDTO.setSettingName(siteSettings.getSiteSettingsPK().getSettingName());
		siteSettingsDTO.setSettingValue(siteSettings.getSettingValue());
		return siteSettingsDTO;
	}


	/**
	 * Constructs UserDTO model by SiteUserQueryResponseDTO
	 *
	 * @param User user
	 * 
	 * @return UserDTO
	 */
	private UserDTO getUserDTO(SiteUserQueryResponseDTO queryResponse) {
		UserDTO userDTO = new UserDTO();
		userDTO.setCompany(queryResponse.getCompany());
		userDTO.setEmail(queryResponse.getEmail());
		userDTO.setFirstName(queryResponse.getFirstName());
		userDTO.setIsActive(queryResponse.getIsActive());
		userDTO.setLastName(queryResponse.getLastName());
		userDTO.setMiddleName(queryResponse.getMiddleName());
		userDTO.setPassword(queryResponse.getPassword());
		userDTO.setUserId(queryResponse.getUserId());
		userDTO.setUsername(queryResponse.getUsername());
		return userDTO;
	}

	/**
	 * Constructs SiteInfoDTO model by site
	 *
	 * @param Site site
	 * 
	 * @return SiteInfoDTO
	 */
	private SiteInfoDTO getSiteInfoDTO(Site site) {
		SiteInfoDTO siteInfoDTO = new SiteInfoDTO();
		siteInfoDTO.setDeactivatedDate(site.getDeactivatedDate());
		siteInfoDTO.setHost(site.getHost());
		siteInfoDTO.setIsActive(site.getActive());
		siteInfoDTO.setName(site.getName());
		siteInfoDTO.setSiteId(site.getId());
		siteInfoDTO.setUpdatedDate(site.getUpdatedDate());
		return siteInfoDTO;
	}

	@Override
	public SiteBrandingDTO getWelcometextAndBranding(Long siteId) {
		SiteBrandingDTO siteBrandingDTO = new SiteBrandingDTO();
		String company = getInfo(siteId).getName();
		List<CustomSections> welcomeTextCustomSections = customSectionsManager.getCustomSection(company, "WelcomePage", "center_2", "en");
		if(welcomeTextCustomSections.size() > 0) {
			siteBrandingDTO.setWelcomeText(welcomeTextCustomSections.get(0).getBodyText());
		}
		SiteConfigsPK siteConfigsPK = new SiteConfigsPK();
		siteConfigsPK.setCompany(company);
		siteConfigsPK.setConfigName("SmallLogo");
		siteBrandingDTO.setLogo(siteConfigsManager.get(siteConfigsPK).getConfigValue());
		return siteBrandingDTO;
	}
	
	@Override
	public List<SiteConfigsDTO> getSiteConfigs(Long siteId) {
		List<SiteConfigs> siteConfigsList = siteConfigsManager.getSiteConfigsByCompany(getInfo(siteId).getName());
		List<SiteConfigsDTO> siteConfigsDTOList = new ArrayList<SiteConfigsDTO>();
		for(SiteConfigs siteConfigs : siteConfigsList){
			SiteConfigsDTO siteConfigsDTO = getSiteConfigsDTO(siteConfigs);
			siteConfigsDTOList.add(siteConfigsDTO);
		}
		
		//add the language list to the existing siteConfig -should eventually use
		//select * from custom_field_enum where column_name = 'Language' - hardcoding for now
		
		SiteConfigsDTO languagesAvailable = siteConfigsManager.getLanguagesAvaiable(siteId);
		siteConfigsDTOList.add(languagesAvailable);
		
		//add the max created date for the site and add it here, cause it is one value for site
		String maxCreatedDate = assetManager.getMaxCreatedDate(siteId);
		SiteConfigsDTO maxCreatedDateDTO = new SiteConfigsDTO();
			maxCreatedDateDTO.setConfigName("maxCreatedDate");
			maxCreatedDateDTO.setConfigValue(maxCreatedDate);
		
		siteConfigsDTOList.add(maxCreatedDateDTO);
		
		return siteConfigsDTOList;
	}

	@Override
	public UserLabelsDTO getCustomLabelsByCompanyAndLanguage(String company, String language) {
		//find out if the site is international or not.
		List<SiteConfigs> siteConfigsList = siteConfigsManager.getSiteConfigsByCompany(company);
		boolean international = false;
		for(SiteConfigs siteConfigs : siteConfigsList){
			SiteConfigsDTO siteConfigsDTO = getSiteConfigsDTO(siteConfigs);
			if(siteConfigsDTO.getConfigName().equals("ProfileColumn"))
				international = "Language".equals(siteConfigsDTO.getConfigValue()) ? true : false;
			if(siteConfigsDTO.getConfigName().equals("ProfileColumnDefault"))
				international = "en".equals(siteConfigsDTO.getConfigValue()) ? true : false;
			if(siteConfigsDTO.getConfigName().equals("DefaultLanguage"))
				international = "en".equals(siteConfigsDTO.getConfigValue()) ? true : false;
		}
		
		return siteManager.getCustomLabelsByCompanyAndLanguage(company, language, international);
	}
	
	@Override
	public CourseLookupsDTO getCourseCatalogList(Long siteId) {
		return siteManager.getCourseCatalogList(siteId);
	}
	
	@Override
	public CourseLookupsDTO getAllCoursesBySiteId(Long siteId) {
		return siteManager.getAllCoursesBySiteId(siteId);
	}

	@Override
	public String getPartnerNameBySiteId(Long siteId) {
		return siteManager.getPartnerNameBySiteId(siteId);
	}
	
	@Override
	public String getSitePassword(String company) {
		return siteManager.getSitePassword(company);
	}
	
	@Override
	public Long getRevisionNumber() {
		return siteManager.getRevisionNumber();
	}
	
	@Override
	public RsaKeysDTO getRsaKeysBySiteId(Long siteId) {
		List<RsaKeys> list = rsaKeysManager.getRsaKeysBySiteId(siteId);
		
		RsaKeysDTO dto = new RsaKeysDTO();
		for(RsaKeys rk : list) {
			
			dto.setCreateDate(rk.getCreateDate());
			dto.setCreateUser(rk.getCreateUser());
			dto.setNotificationEmail(rk.getNotificationEmail());
			dto.setPassPhrase(rk.getPassPhrase());
			dto.setRsaKeysTypeId(rk.getRsaKeysTypeId());
			dto.setSiteId(rk.getSiteId());
			
			try {
				//get the privateKey from the blob column and put it into string
				InputStream is = rk.getPrivateKey().getBinaryStream();
				BufferedReader bis = new BufferedReader(new InputStreamReader(is));
				
				StringBuffer strBuf = new StringBuffer();
				String str;
				while((str = bis.readLine()) != null) 
					strBuf.append(str).append("\n\r");
				
				//now strip the begin/end private key
				String privateKey = strBuf.toString(); //trimRsaKeyData(strBuf.toString());
				dto.setPrivateKey(privateKey);
				
				//get the public key from teh blob column and put it into string
				is = rk.getPublicKey().getBinaryStream();
				bis = new BufferedReader(new InputStreamReader(is));
				
				strBuf = new StringBuffer();
				while((str = bis.readLine()) != null) 
					strBuf.append(str).append("\n\r");
				
				//now strip the begin/end private key
				String publicKey = strBuf.toString(); //trimRsaKeyData(strBuf.toString());
				dto.setPublicKey(publicKey);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		return dto;
	}
	
	private String trimRsaKeyData(String key) {
		key = key.replaceAll("-", "");
		key = key.replaceAll("BEGIN", "");
		key = key.replaceAll("END", "");
		key = key.replaceAll("RSA", "");
		key = key.replaceAll("PRIVATE", "");
		key = key.replaceAll("PUBLIC", "");
		key = key.replaceAll("KEY", "");
		key = key.replaceAll("CERTIFICATE", "");
		key = key.replaceAll(" ", "");
		
		return key;
	}
	
	private SiteConfigsDTO getSiteConfigsDTO(SiteConfigs siteConfigs) {
		SiteConfigsDTO siteConfigsDTO = new SiteConfigsDTO();
		siteConfigsDTO.setConfigName(siteConfigs.getSiteConfigsPK().getConfigName());
		siteConfigsDTO.setConfigValue(siteConfigs.getConfigValue());
		return siteConfigsDTO;
	}

	@Override
	public LanguagesDTO getAvailableLanguagesBySiteId(Long siteId) {
		List <Language> languagesList = siteManager.getAvailableLanguagesBySiteId(siteId);
		
		LanguagesDTO languagesDTO = getDTOFromModel(languagesList);
		return languagesDTO;
	}
	
	private LanguagesDTO getDTOFromModel(List <Language> languagesList) {
		ArrayList <LanguageDTO> dtoList = new ArrayList<LanguageDTO> ();
		for(Language lang : languagesList) {
			LanguageDTO langDTO = getDTOFromModel(lang);
			dtoList.add(langDTO);
		}
		
		com.lrn.dto.LanguagesDTO dto = new LanguagesDTO();
			dto.setLanguagesList(dtoList);
		return dto;
	}
	
	private LanguageDTO getDTOFromModel(Language lang) {
		LanguageDTO dto = new LanguageDTO();
		dto.setCode(lang.getLangCode());
		dto.setCountryCode(lang.getCountryCode());
		dto.setEnName(lang.getEnName());
		dto.setLabel(lang.getLabel());
		dto.setLanguage(lang.getLanguagePK().getLanguage());
		
		return dto;
	}
	/**
	 * @param environmentName the environmentName to set
	 */
	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
}
