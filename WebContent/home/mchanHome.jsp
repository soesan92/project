<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MCHAN</title>

</head>

<body>



	<!-- <div class="hero-unit"> -->
		<table class="table table-bordered">
			<!-- <tbody> -->
				<tr ><!-- class="font_label" -->
					<!-- 1st side -->
					<td class="foreground">
					
						<h4>
							<p class="text-center text-error">Board Members</p>
						</h4>
						<s:if test="%{!staffList.isEmpty}">
							<dl class="dl-horizontal">
								<s:subset decider="boardMemberDecider" source="staffList">
									<s:iterator>
										<dt><s:property value="description" /></dt>
										<dd>
											<a href="#"
												title="Name	   : <s:property value="name"/>
												   E-mail	   : <s:property value="email"/>
												   Phone No	   : <s:property value="phone"/>
												   Department : <s:property value="department"/>
												   Position	   : <s:property value="description"/>">
												<s:property value="name" />,<s:property value="department" />
											</a>
										</dd>
									</s:iterator>
								</s:subset>
							</dl>
						</s:if>
				<!-- <dl class="dl-horizontal">
						<dt>Episcopal Director</dt>
						<dd>Bp.Alexander Pyone Cho</dd>
						<dt>Spiritual Director</dt>
						<dd>Fr.Christopher Raj</dd>
						<dt>President</dt>
						<dd>Dr.Cho Lay Mar</dd>
						<dt>Vice President</dt>
						<dd>Sr.Magdalene Lim,SJA</dd>
						<dt>Member</dt>
						<dd>Sr.Mary Cho Mar, MPBS</dd>
						<dt>Member</dt>
						<dd>Sr.Bernadette, SJA</dd>
						<dt>Member</dt>
						<dd>Sr.Rosy Thin Thin Aye, RNDM</dd>
						<dt>Member</dt>
						<dd>Augustine Van Hel Thang,</dd>
						<dd>KMSS-Hakha</dd> 
					</dl> -->
					<h4>
						<p class="text-center text-error">Advisors</p>
					</h4>
					<s:if test="%{!staffList.isEmpty}">
						<dl class="dl-horizontal">
							<s:subset decider="advisorsDecider" source="staffList">
								<s:iterator>
									<table >
										<tr>
											<dt><s:property value="description" /></dt>
											<dd>
											<a href="#" data-toggle="tooltip" 
															title="Name	   : <s:property value="name"/>
															   E-mail	   : <s:property value="email"/>
															   Phone No	   : <s:property value="phone"/>
															   Department : <s:property value="department"/>
															   Position	   : <s:property value="description"/>">
												<s:property value="name" />,<s:property value="department" />
											</a>
											</dd>
										</tr>
									</table>
								</s:iterator>
							</s:subset>
						</dl>
					</s:if>
				<!-- <dl class="dl-horizontal">
						<dt>Dr.Richard Win Tun Kyi</dt>
						<dd>KMSS National Director</dd>
						<dt>Fr.Victor Nyan Myint</dt>
						<dd>St.Edward's PP,Mingaladon</dd>
						<dt>Fr.Win Than</dt>
						<dd>Deputy Director,KMSS Pathein</dd>
						<dt>Dr.Soe Naing</dt>
						<dd>AIDS Alliance. Director</dd>
						<dt>Sr.Mary Dillon,MSSC</dt>
						<dd>Director,Hope Center,Myintkyina</dd>
						<dt>Rita Khin San Aye,SJA</dt>
						<dd>Pravicial Superior</dd>
						<dt>Sr.Martha Paul,SJA</dt>
						<dd>Director,Myitta Kyaemone</dd>
						<dd>Kyaikkamee,Mon State</dd>
						<dt>Mary Seng Ra</dt>
						<dd>HIV/AIDS Counselor,Lashio KMSS</dd>
					</dl> -->
					
						<h4>
							<p class="text-center text-error">Staff</p>
						</h4>
					<s:if test="%{!staffList.isEmpty}">
						<dl class="dl-horizontal">
							<s:subset decider="staffDecider" source="staffList">
								<s:iterator>
									<table>
										<tr>
											<dt><s:property value="description" /></dt>
											
											<dd>
												<a href="#" data-toggle="tooltip" 
																title="Name	   : <s:property value="name"/>
																   E-mail	   : <s:property value="email"/>
																   Phone No	   : <s:property value="phone"/>
																   Department : <s:property value="department"/>
																   Position	   : <s:property value="description"/>">
													<s:property value="name" />,<s:property value="department" />
												</a>
											</dd>
										</tr>
									</table>
								</s:iterator>
							</s:subset>
						</dl>
					</s:if>
				<!-- <dl class="dl-horizontal">
						<dt>Julia Aye Thida</dt>
						<dd>Coordinator</dd>
						<dt>Theresa Min Min Myat</dt>
						<dd>Assistant Coordinator</dd>
						<dt>Marie Barbara</dt>
						<dd>Finance/Admin Assistant</dd>
						<dt>Juliana Aye Thandar</dt>
						<dd>Program Assistant</dd>
						<dt>Hay Mar Lwin</dt>
						<dd>Office Assistant</dd>
						<dt>Sr.Mary Grenough,MM</dt>
						<dd>Consultant</dd>
					</dl> -->
						<!-- <p class="text-center">
							<a href="./bootstrap/imgs/java.jpg"> 
								<img src="./bootstrap/imgs/java.jpg" class="img-polaroid" style="height: 100px; width: 150px; margin: center;" />
							</a>
						</p>
						<p class="text-center text-success">A typical workshop of MCHAN</p> -->
						<h4>
							<p class="text-center text-error">Activities</p>
						</h4>
						<ul>
							<li>Regular team and national network coordination meetings.</li>
							<li>Networking with HIV/AIDS-related organizations</li>
							<li>HIV/AIDS education and training workshops.</li>
							<li>Human sexuality,gender and migration,anti-human
								trafficking education.</li>
							<li>Development and publication of ICE materials.</li>
							<li>Lending library for HIV/AIDS,sexuality,etc... resource
								materials.</li>
							<li>Assist with resource generation for network programs.</li>
							<li>Publication of periodic Network newsletter.</li>
							<li>Publication of Catholic HIV/AIDS Directory.</li>
							<li>Provision of annual care-givers retreat and HIV/AIDS
								related spirituality materials.</li>
							<li>Provide information,initial counseling,referrals for
								inquirers</li>
						</ul>
						<!-- <p class="text-center">
							<a href="./bootstrap/imgs/java.jpg">
								<img src="./bootstrap/imgs/java.jpg" class="img-polaroid" style="height: 120px; width: 180px; margin: center;" />
							</a>
						</p>
						<p class="text-center text-success">Second Retreat for Caregivers</p> -->
						<h4>
							<p class="text-center text-error">MEMBERS</p>
						</h4>

						<p class="text-center">
							Any individuals or groups who are
							actively involved in Catholic HIV/AIDS ministries in Myanmar who
							wish to participate in the Network's programs or activities.
						</p>
					</td>
					<!-- 2nd side -->
					<td bgcolor= "#f3f0f5">
						<p class="text-center">
							<a href="./bootstrap/imgs/cross.jpg">
								<img src="./bootstrap/imgs/cross.jpg" class="img-rounded" style="height: 200px; width: 180px; margin: center;" />
							</a>
						</p>
						
						
						
						<h4>
							<p class="text-center text-error">VISION</p>
						</h4>

						<p class="text-center">
							All who are living with and affected by HIV/AIDS
							receive open and compassionate treatment, care, support, and prevention services
							regardless of religious beliefs and ethnic origins.
						</p>
						
						
						<h4>
							<p class="text-center text-error">MISSION</p>
						</h4>

						<p class="text-center">
							Inspired by the Catholic Social Teachings of the church,
							to improve networking and develop programs to reduce stigma
							and discrimination, and to increase capacities for HIV/AIDS treament,
							care, support and prevention services.
						</p>
						
						
						
						<h4>
							<p class="text-center text-error">OBJECTIVES</p>
						</h4>
						<ul>
							<li>
								To share program information updates and plan
								Network key activities with the Network Team.
							</li>
							<li>
								To identify resources, organizations and individuals
								with whom to interact and cooperate to fulfill our mission.
							</li>
							<li>
								To access and disseminate ongoing updated
								international developments in HIV/AIDS work
								with Network and others interested.
							</li>
							<li>
								To promote and sustain the spiritual growth of
								persons involved in HIV/AIDS work.
							</li>
							<li>
								To promote concerted efforts to reduce new HIV
								infections in collaboration with other religious
								and ethnic groups, NGOs, the UN and government bodies.
							</li>
							<li>
								To maintain cooperation wit Church leaders regarding
								HIV/AIDS ministries.
							</li>
							
						</ul>
						
					</td>
				</tr>
			<!-- </tbody> -->
		</table>
	<!-- </div> -->
</body>
</html>