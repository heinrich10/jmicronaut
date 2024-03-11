INSERT INTO `continents` (`code`, `name`) VALUES
('AF', 'Africa'),
('AN', 'Antarctica'),
('AS', 'Asia'),
('EU', 'Europe'),
('NA', 'North America'),
('OC', 'Oceania'),
('SA', 'South America');

INSERT INTO `countries`
(`code`, `name`, `phone`, `symbol`, `capital`, `currency`, `continent_code`, `alpha_3`) VALUES
('AF', 'Afghanistan', 93, '؋', 'Kabul', 'AFN', 'AS', 'AFG'),
('AX', 'Aland Islands', 358, '€', 'Mariehamn', 'EUR', 'EU', 'ALA'),
('AL', 'Albania', 355, 'Lek', 'Tirana', 'ALL', 'EU', 'ALB'),
('DZ', 'Algeria', 213, 'دج', 'Algiers', 'DZD', 'AF', 'DZA'),
('AS', 'American Samoa', 1684, '$', 'Pago Pago', 'USD', 'OC', 'ASM'),
('AD', 'Andorra', 376, '€', 'Andorra la Vella', 'EUR', 'EU', 'AND'),
('AO', 'Angola', 244, 'Kz', 'Luanda', 'AOA', 'AF', 'AGO'),
('AI', 'Anguilla', 1264, '$', 'The Valley', 'XCD', 'NA', 'AIA'),
('AQ', 'Antarctica', 672, '$', 'Antarctica', 'AAD', 'AN', 'ATA'),
('AG', 'Antigua and Barbuda', 1268, '$', 'St. Johns', 'XCD', 'NA', 'ATG'),
('AR', 'Argentina', 54, '$', 'Buenos Aires', 'ARS', 'SA', 'ARG'),
('AM', 'Armenia', 374, '֏', 'Yerevan', 'AMD', 'AS', 'ARM'),
('AW', 'Aruba', 297, 'ƒ', 'Oranjestad', 'AWG', 'NA', 'ABW'),
('AU', 'Australia', 61, '$', 'Canberra', 'AUD', 'OC', 'AUS'),
('AT', 'Austria', 43, '€', 'Vienna', 'EUR', 'EU', 'AUT'),
('AZ', 'Azerbaijan', 994, 'm', 'Baku', 'AZN', 'AS', 'AZE'),
('BS', 'Bahamas', 1242, 'B$', 'Nassau', 'BSD', 'NA', 'BHS'),
('BH', 'Bahrain', 973, '.د.ب', 'Manama', 'BHD', 'AS', 'BHR'),
('BD', 'Bangladesh', 880, '৳', 'Dhaka', 'BDT', 'AS', 'BGD'),
('BB', 'Barbados', 1246, 'Bds$', 'Bridgetown', 'BBD', 'NA', 'BRB'),
('BY', 'Belarus', 375, 'Br', 'Minsk', 'BYN', 'EU', 'BLR'),
('BE', 'Belgium', 32, '€', 'Brussels', 'EUR', 'EU', 'BEL'),
('BZ', 'Belize', 501, '$', 'Belmopan', 'BZD', 'NA', 'BLZ'),
('BJ', 'Benin', 229, 'CFA', 'Porto-Novo', 'XOF', 'AF', 'BEN'),
('BM', 'Bermuda', 1441, '$', 'Hamilton', 'BMD', 'NA', 'BMU'),
('BT', 'Bhutan', 975, 'Nu.', 'Thimphu', 'BTN', 'AS', 'BTN'),
('BO', 'Bolivia', 591, 'Bs.', 'Sucre', 'BOB', 'SA', 'BOL'),
('BQ', 'Bonaire, Sint Eustatius and Saba', 599, '$', 'Kralendijk', 'USD', 'NA', 'BES'),
('BA', 'Bosnia and Herzegovina', 387, 'KM', 'Sarajevo', 'BAM', 'EU', 'BIH'),
('BW', 'Botswana', 267, 'P', 'Gaborone', 'BWP', 'AF', 'BWA'),
('BV', 'Bouvet Island', 55, 'kr', '', 'NOK', 'AN', 'BVT'),
('BR', 'Brazil', 55, 'R$', 'Brasilia', 'BRL', 'SA', 'BRA'),
('IO', 'British Indian Ocean Territory', 246, '$', 'Diego Garcia', 'USD', 'AS', 'IOT'),
('BN', 'Brunei Darussalam', 673, 'B$', 'Bandar Seri Begawan', 'BND', 'AS', 'BRN'),
('BG', 'Bulgaria', 359, 'Лв.', 'Sofia', 'BGN', 'EU', 'BGR'),
('BF', 'Burkina Faso', 226, 'CFA', 'Ouagadougou', 'XOF', 'AF', 'BFA'),
('BI', 'Burundi', 257, 'FBu', 'Bujumbura', 'BIF', 'AF', 'BDI'),
('KH', 'Cambodia', 855, 'KHR', 'Phnom Penh', 'KHR', 'AS', 'KHM'),
('CM', 'Cameroon', 237, 'FCFA', 'Yaounde', 'XAF', 'AF', 'CMR'),
('CA', 'Canada', 1, '$', 'Ottawa', 'CAD', 'NA', 'CAN'),
('CV', 'Cape Verde', 238, '$', 'Praia', 'CVE', 'AF', 'CPV'),
('KY', 'Cayman Islands', 1345, '$', 'George Town', 'KYD', 'NA', 'CYM'),
('CF', 'Central African Republic', 236, 'FCFA', 'Bangui', 'XAF', 'AF', 'CAF'),
('TD', 'Chad', 235, 'FCFA', 'NDjamena', 'XAF', 'AF', 'TCD'),
('CL', 'Chile', 56, '$', 'Santiago', 'CLP', 'SA', 'CHL'),
('CN', 'China', 86, '¥', 'Beijing', 'CNY', 'AS', 'CHN'),
('CX', 'Christmas Island', 61, '$', 'Flying Fish Cove', 'AUD', 'AS', 'CXR'),
('CC', 'Cocos (Keeling) Islands', 672, '$', 'West Island', 'AUD', 'AS', 'CCK'),
('CO', 'Colombia', 57, '$', 'Bogota', 'COP', 'SA', 'COL'),
('KM', 'Comoros', 269, 'CF', 'Moroni', 'KMF', 'AF', 'COM'),
('CG', 'Congo', 242, 'FC', 'Brazzaville', 'XAF', 'AF', 'COG'),
('CD', 'Congo, Democratic Republic of the Congo', 242, 'FC', 'Kinshasa', 'CDF', 'AF', 'COD'),
('CK', 'Cook Islands', 682, '$', 'Avarua', 'NZD', 'OC', 'COK'),
('CR', 'Costa Rica', 506, '₡', 'San Jose', 'CRC', 'NA', 'CRI'),
('CI', 'Cote DIvoire', 225, 'CFA', 'Yamoussoukro', 'XOF', 'AF', 'CIV'),
('HR', 'Croatia', 385, 'kn', 'Zagreb', 'HRK', 'EU', 'HRV'),
('CU', 'Cuba', 53, '$', 'Havana', 'CUP', 'NA', 'CUB'),
('CW', 'Curacao', 599, 'ƒ', 'Willemstad', 'ANG', 'NA', 'CUW'),
('CY', 'Cyprus', 357, '€', 'Nicosia', 'EUR', 'AS', 'CYP'),
('CZ', 'Czech Republic', 420, 'Kč', 'Prague', 'CZK', 'EU', 'CZE'),
('DK', 'Denmark', 45, 'Kr.', 'Copenhagen', 'DKK', 'EU', 'DNK'),
('DJ', 'Djibouti', 253, 'Fdj', 'Djibouti', 'DJF', 'AF', 'DJI'),
('DM', 'Dominica', 1767, '$', 'Roseau', 'XCD', 'NA', 'DMA'),
('DO', 'Dominican Republic', 1809, '$', 'Santo Domingo', 'DOP', 'NA', 'DOM'),
('EC', 'Ecuador', 593, '$', 'Quito', 'USD', 'SA', 'ECU'),
('EG', 'Egypt', 20, 'ج.م', 'Cairo', 'EGP', 'AF', 'EGY'),
('SV', 'El Salvador', 503, '$', 'San Salvador', 'USD', 'NA', 'SLV'),
('GQ', 'Equatorial Guinea', 240, 'FCFA', 'Malabo', 'XAF', 'AF', 'GNQ'),
('ER', 'Eritrea', 291, 'Nfk', 'Asmara', 'ERN', 'AF', 'ERI'),
('EE', 'Estonia', 372, '€', 'Tallinn', 'EUR', 'EU', 'EST'),
('ET', 'Ethiopia', 251, 'Nkf', 'Addis Ababa', 'ETB', 'AF', 'ETH'),
('FK', 'Falkland Islands (Malvinas)', 500, '£', 'Stanley', 'FKP', 'SA', 'FLK'),
('FO', 'Faroe Islands', 298, 'Kr.', 'Torshavn', 'DKK', 'EU', 'FRO'),
('FJ', 'Fiji', 679, 'FJ$', 'Suva', 'FJD', 'OC', 'FJI'),
('FI', 'Finland', 358, '€', 'Helsinki', 'EUR', 'EU', 'FIN'),
('FR', 'France', 33, '€', 'Paris', 'EUR', 'EU', 'FRA'),
('GF', 'French Guiana', 594, '€', 'Cayenne', 'EUR', 'SA', 'GUF'),
('PF', 'French Polynesia', 689, '₣', 'Papeete', 'XPF', 'OC', 'PYF'),
('TF', 'French Southern Territories', 262, '€', 'Port-aux-Francais', 'EUR', 'AN', 'ATF'),
('GA', 'Gabon', 241, 'FCFA', 'Libreville', 'XAF', 'AF', 'GAB'),
('GM', 'Gambia', 220, 'D', 'Banjul', 'GMD', 'AF', 'GMB'),
('GE', 'Georgia', 995, 'ლ', 'Tbilisi', 'GEL', 'AS', 'GEO'),
('DE', 'Germany', 49, '€', 'Berlin', 'EUR', 'EU', 'DEU'),
('GH', 'Ghana', 233, 'GH₵', 'Accra', 'GHS', 'AF', 'GHA'),
('GI', 'Gibraltar', 350, '£', 'Gibraltar', 'GIP', 'EU', 'GIB'),
('GR', 'Greece', 30, '€', 'Athens', 'EUR', 'EU', 'GRC'),
('GL', 'Greenland', 299, 'Kr.', 'Nuuk', 'DKK', 'NA', 'GRL'),
('GD', 'Grenada', 1473, '$', 'St. Georges', 'XCD', 'NA', 'GRD'),
('GP', 'Guadeloupe', 590, '€', 'Basse-Terre', 'EUR', 'NA', 'GLP'),
('GU', 'Guam', 1671, '$', 'Hagatna', 'USD', 'OC', 'GUM'),
('GT', 'Guatemala', 502, 'Q', 'Guatemala City', 'GTQ', 'NA', 'GTM'),
('GG', 'Guernsey', 44, '£', 'St Peter Port', 'GBP', 'EU', 'GGY'),
('GN', 'Guinea', 224, 'FG', 'Conakry', 'GNF', 'AF', 'GIN'),
('GW', 'Guinea-Bissau', 245, 'CFA', 'Bissau', 'XOF', 'AF', 'GNB'),
('GY', 'Guyana', 592, '$', 'Georgetown', 'GYD', 'SA', 'GUY'),
('HT', 'Haiti', 509, 'G', 'Port-au-Prince', 'HTG', 'NA', 'HTI'),
('HM', 'Heard Island and Mcdonald Islands', 0, '$', '', 'AUD', 'AN', 'HMD'),
('VA', 'Holy See (Vatican City State)', 39, '€', 'Vatican City', 'EUR', 'EU', 'VAT'),
('HN', 'Honduras', 504, 'L', 'Tegucigalpa', 'HNL', 'NA', 'HND'),
('HK', 'Hong Kong', 852, '$', 'Hong Kong', 'HKD', 'AS', 'HKG'),
('HU', 'Hungary', 36, 'Ft', 'Budapest', 'HUF', 'EU', 'HUN'),
('IS', 'Iceland', 354, 'kr', 'Reykjavik', 'ISK', 'EU', 'ISL'),
('IN', 'India', 91, '₹', 'New Delhi', 'INR', 'AS', 'IND'),
('ID', 'Indonesia', 62, 'Rp', 'Jakarta', 'IDR', 'AS', 'IDN'),
('IR', 'Iran, Islamic Republic of', 98, '﷼', 'Tehran', 'IRR', 'AS', 'IRN'),
('IQ', 'Iraq', 964, 'د.ع', 'Baghdad', 'IQD', 'AS', 'IRQ'),
('IE', 'Ireland', 353, '€', 'Dublin', 'EUR', 'EU', 'IRL'),
('IM', 'Isle of Man', 44, '£', 'Douglas, Isle of Man', 'GBP', 'EU', 'IMN'),
('IL', 'Israel', 972, '₪', 'Jerusalem', 'ILS', 'AS', 'ISR'),
('IT', 'Italy', 39, '€', 'Rome', 'EUR', 'EU', 'ITA'),
('JM', 'Jamaica', 1876, 'J$', 'Kingston', 'JMD', 'NA', 'JAM'),
('JP', 'Japan', 81, '¥', 'Tokyo', 'JPY', 'AS', 'JPN'),
('JE', 'Jersey', 44, '£', 'Saint Helier', 'GBP', 'EU', 'JEY'),
('JO', 'Jordan', 962, 'ا.د', 'Amman', 'JOD', 'AS', 'JOR'),
('KZ', 'Kazakhstan', 7, 'лв', 'Astana', 'KZT', 'AS', 'KAZ'),
('KE', 'Kenya', 254, 'KSh', 'Nairobi', 'KES', 'AF', 'KEN'),
('KI', 'Kiribati', 686, '$', 'Tarawa', 'AUD', 'OC', 'KIR'),
('KP', 'Korea, Democratic Peoples Republic of', 850, '₩', 'Pyongyang', 'KPW', 'AS', 'PRK'),
('KR', 'Korea, Republic of', 82, '₩', 'Seoul', 'KRW', 'AS', 'KOR'),
('XK', 'Kosovo', 383, '€', 'Pristina', 'EUR', 'EU', 'XKX'),
('KW', 'Kuwait', 965, 'ك.د', 'Kuwait City', 'KWD', 'AS', 'KWT'),
('KG', 'Kyrgyzstan', 996, 'лв', 'Bishkek', 'KGS', 'AS', 'KGZ'),
('LA', 'Lao Peoples Democratic Republic', 856, '₭', 'Vientiane', 'LAK', 'AS', 'LAO'),
('LV', 'Latvia', 371, '€', 'Riga', 'EUR', 'EU', 'LVA'),
('LB', 'Lebanon', 961, '£', 'Beirut', 'LBP', 'AS', 'LBN'),
('LS', 'Lesotho', 266, 'L', 'Maseru', 'LSL', 'AF', 'LSO'),
('LR', 'Liberia', 231, '$', 'Monrovia', 'LRD', 'AF', 'LBR'),
('LY', 'Libyan Arab Jamahiriya', 218, 'د.ل', 'Tripolis', 'LYD', 'AF', 'LBY'),
('LI', 'Liechtenstein', 423, 'CHf', 'Vaduz', 'CHF', 'EU', 'LIE'),
('LT', 'Lithuania', 370, '€', 'Vilnius', 'EUR', 'EU', 'LTU'),
('LU', 'Luxembourg', 352, '€', 'Luxembourg', 'EUR', 'EU', 'LUX'),
('MO', 'Macao', 853, '$', 'Macao', 'MOP', 'AS', 'MAC'),
('MK', 'Macedonia, the Former Yugoslav Republic of', 389, 'ден', 'Skopje', 'MKD', 'EU', 'MKD'),
('MG', 'Madagascar', 261, 'Ar', 'Antananarivo', 'MGA', 'AF', 'MDG'),
('MW', 'Malawi', 265, 'MK', 'Lilongwe', 'MWK', 'AF', 'MWI'),
('MY', 'Malaysia', 60, 'RM', 'Kuala Lumpur', 'MYR', 'AS', 'MYS'),
('MV', 'Maldives', 960, 'Rf', 'Male', 'MVR', 'AS', 'MDV'),
('ML', 'Mali', 223, 'CFA', 'Bamako', 'XOF', 'AF', 'MLI'),
('MT', 'Malta', 356, '€', 'Valletta', 'EUR', 'EU', 'MLT'),
('MH', 'Marshall Islands', 692, '$', 'Majuro', 'USD', 'OC', 'MHL'),
('MQ', 'Martinique', 596, '€', 'Fort-de-France', 'EUR', 'NA', 'MTQ'),
('MR', 'Mauritania', 222, 'MRU', 'Nouakchott', 'MRO', 'AF', 'MRT'),
('MU', 'Mauritius', 230, '₨', 'Port Louis', 'MUR', 'AF', 'MUS'),
('YT', 'Mayotte', 262, '€', 'Mamoudzou', 'EUR', 'AF', 'MYT'),
('MX', 'Mexico', 52, '$', 'Mexico City', 'MXN', 'NA', 'MEX'),
('FM', 'Micronesia, Federated States of', 691, '$', 'Palikir', 'USD', 'OC', 'FSM'),
('MD', 'Moldova, Republic of', 373, 'L', 'Chisinau', 'MDL', 'EU', 'MDA'),
('MC', 'Monaco', 377, '€', 'Monaco', 'EUR', 'EU', 'MCO'),
('MN', 'Mongolia', 976, '₮', 'Ulan Bator', 'MNT', 'AS', 'MNG'),
('ME', 'Montenegro', 382, '€', 'Podgorica', 'EUR', 'EU', 'MNE'),
('MS', 'Montserrat', 1664, '$', 'Plymouth', 'XCD', 'NA', 'MSR'),
('MA', 'Morocco', 212, 'DH', 'Rabat', 'MAD', 'AF', 'MAR'),
('MZ', 'Mozambique', 258, 'MT', 'Maputo', 'MZN', 'AF', 'MOZ'),
('MM', 'Myanmar', 95, 'K', 'Nay Pyi Taw', 'MMK', 'AS', 'MMR'),
('NA', 'Namibia', 264, '$', 'Windhoek', 'NAD', 'AF', 'NAM'),
('NR', 'Nauru', 674, '$', 'Yaren', 'AUD', 'OC', 'NRU'),
('NP', 'Nepal', 977, '₨', 'Kathmandu', 'NPR', 'AS', 'NPL'),
('NL', 'Netherlands', 31, '€', 'Amsterdam', 'EUR', 'EU', 'NLD'),
('AN', 'Netherlands Antilles', 599, 'NAf', 'Willemstad', 'ANG', 'NA', 'ANT'),
('NC', 'New Caledonia', 687, '₣', 'Noumea', 'XPF', 'OC', 'NCL'),
('NZ', 'New Zealand', 64, '$', 'Wellington', 'NZD', 'OC', 'NZL'),
('NI', 'Nicaragua', 505, 'C$', 'Managua', 'NIO', 'NA', 'NIC'),
('NE', 'Niger', 227, 'CFA', 'Niamey', 'XOF', 'AF', 'NER'),
('NG', 'Nigeria', 234, '₦', 'Abuja', 'NGN', 'AF', 'NGA'),
('NU', 'Niue', 683, '$', 'Alofi', 'NZD', 'OC', 'NIU'),
('NF', 'Norfolk Island', 672, '$', 'Kingston', 'AUD', 'OC', 'NFK'),
('MP', 'Northern Mariana Islands', 1670, '$', 'Saipan', 'USD', 'OC', 'MNP'),
('NO', 'Norway', 47, 'kr', 'Oslo', 'NOK', 'EU', 'NOR'),
('OM', 'Oman', 968, '.ع.ر', 'Muscat', 'OMR', 'AS', 'OMN'),
('PK', 'Pakistan', 92, '₨', 'Islamabad', 'PKR', 'AS', 'PAK'),
('PW', 'Palau', 680, '$', 'Melekeok', 'USD', 'OC', 'PLW'),
('PS', 'Palestinian Territory, Occupied', 970, '₪', 'East Jerusalem', 'ILS', 'AS', 'PSE'),
('PA', 'Panama', 507, 'B/.', 'Panama City', 'PAB', 'NA', 'PAN'),
('PG', 'Papua New Guinea', 675, 'K', 'Port Moresby', 'PGK', 'OC', 'PNG'),
('PY', 'Paraguay', 595, '₲', 'Asuncion', 'PYG', 'SA', 'PRY'),
('PE', 'Peru', 51, 'S/.', 'Lima', 'PEN', 'SA', 'PER'),
('PH', 'Philippines', 63, '₱', 'Manila', 'PHP', 'AS', 'PHL'),
('PN', 'Pitcairn', 64, '$', 'Adamstown', 'NZD', 'OC', 'PCN'),
('PL', 'Poland', 48, 'zł', 'Warsaw', 'PLN', 'EU', 'POL'),
('PT', 'Portugal', 351, '€', 'Lisbon', 'EUR', 'EU', 'PRT'),
('PR', 'Puerto Rico', 1787, '$', 'San Juan', 'USD', 'NA', 'PRI'),
('QA', 'Qatar', 974, 'ق.ر', 'Doha', 'QAR', 'AS', 'QAT'),
('RE', 'Reunion', 262, '€', 'Saint-Denis', 'EUR', 'AF', 'REU'),
('RO', 'Romania', 40, 'lei', 'Bucharest', 'RON', 'EU', 'ROM'),
('RU', 'Russian Federation', 7, '₽', 'Moscow', 'RUB', 'AS', 'RUS'),
('RW', 'Rwanda', 250, 'FRw', 'Kigali', 'RWF', 'AF', 'RWA'),
('BL', 'Saint Barthelemy', 590, '€', 'Gustavia', 'EUR', 'NA', 'BLM'),
('SH', 'Saint Helena', 290, '£', 'Jamestown', 'SHP', 'AF', 'SHN'),
('KN', 'Saint Kitts and Nevis', 1869, '$', 'Basseterre', 'XCD', 'NA', 'KNA'),
('LC', 'Saint Lucia', 1758, '$', 'Castries', 'XCD', 'NA', 'LCA'),
('MF', 'Saint Martin', 590, '€', 'Marigot', 'EUR', 'NA', 'MAF'),
('PM', 'Saint Pierre and Miquelon', 508, '€', 'Saint-Pierre', 'EUR', 'NA', 'SPM'),
('VC', 'Saint Vincent and the Grenadines', 1784, '$', 'Kingstown', 'XCD', 'NA', 'VCT'),
('WS', 'Samoa', 684, 'SAT', 'Apia', 'WST', 'OC', 'WSM'),
('SM', 'San Marino', 378, '€', 'San Marino', 'EUR', 'EU', 'SMR'),
('ST', 'Sao Tome and Principe', 239, 'Db', 'Sao Tome', 'STD', 'AF', 'STP'),
('SA', 'Saudi Arabia', 966, '﷼', 'Riyadh', 'SAR', 'AS', 'SAU'),
('SN', 'Senegal', 221, 'CFA', 'Dakar', 'XOF', 'AF', 'SEN'),
('RS', 'Serbia', 381, 'din', 'Belgrade', 'RSD', 'EU', 'SRB'),
('CS', 'Serbia and Montenegro', 381, 'din', 'Belgrade', 'RSD', 'EU', 'SCG'),
('SC', 'Seychelles', 248, 'SRe', 'Victoria', 'SCR', 'AF', 'SYC'),
('SL', 'Sierra Leone', 232, 'Le', 'Freetown', 'SLL', 'AF', 'SLE'),
('SG', 'Singapore', 65, '$', 'Singapur', 'SGD', 'AS', 'SGP'),
('SX', 'Sint Maarten', 721, 'ƒ', 'Philipsburg', 'ANG', 'NA', 'SXM'),
('SK', 'Slovakia', 421, '€', 'Bratislava', 'EUR', 'EU', 'SVK'),
('SI', 'Slovenia', 386, '€', 'Ljubljana', 'EUR', 'EU', 'SVN'),
('SB', 'Solomon Islands', 677, 'Si$', 'Honiara', 'SBD', 'OC', 'SLB'),
('SO', 'Somalia', 252, 'Sh.so.', 'Mogadishu', 'SOS', 'AF', 'SOM'),
('ZA', 'South Africa', 27, 'R', 'Pretoria', 'ZAR', 'AF', 'ZAF'),
('GS', 'South Georgia and the South Sandwich Islands', 500, '£', 'Grytviken', 'GBP', 'AN', 'SGS'),
('SS', 'South Sudan', 211, '£', 'Juba', 'SSP', 'AF', 'SSD'),
('ES', 'Spain', 34, '€', 'Madrid', 'EUR', 'EU', 'ESP'),
('LK', 'Sri Lanka', 94, 'Rs', 'Colombo', 'LKR', 'AS', 'LKA'),
('SD', 'Sudan', 249, '.س.ج', 'Khartoum', 'SDG', 'AF', 'SDN'),
('SR', 'Suriname', 597, '$', 'Paramaribo', 'SRD', 'SA', 'SUR'),
('SJ', 'Svalbard and Jan Mayen', 47, 'kr', 'Longyearbyen', 'NOK', 'EU', 'SJM'),
('SZ', 'Swaziland', 268, 'E', 'Mbabane', 'SZL', 'AF', 'SWZ'),
('SE', 'Sweden', 46, 'kr', 'Stockholm', 'SEK', 'EU', 'SWE'),
('CH', 'Switzerland', 41, 'CHf', 'Berne', 'CHF', 'EU', 'CHE'),
('SY', 'Syrian Arab Republic', 963, 'LS', 'Damascus', 'SYP', 'AS', 'SYR'),
('TW', 'Taiwan, Province of China', 886, '$', 'Taipei', 'TWD', 'AS', 'TWN'),
('TJ', 'Tajikistan', 992, 'SM', 'Dushanbe', 'TJS', 'AS', 'TJK'),
('TZ', 'Tanzania, United Republic of', 255, 'TSh', 'Dodoma', 'TZS', 'AF', 'TZA'),
('TH', 'Thailand', 66, '฿', 'Bangkok', 'THB', 'AS', 'THA'),
('TL', 'Timor-Leste', 670, '$', 'Dili', 'USD', 'AS', 'TLS'),
('TG', 'Togo', 228, 'CFA', 'Lome', 'XOF', 'AF', 'TGO'),
('TK', 'Tokelau', 690, '$', '', 'NZD', 'OC', 'TKL'),
('TO', 'Tonga', 676, '$', 'Nukualofa', 'TOP', 'OC', 'TON'),
('TT', 'Trinidad and Tobago', 1868, '$', 'Port of Spain', 'TTD', 'NA', 'TTO'),
('TN', 'Tunisia', 216, 'ت.د', 'Tunis', 'TND', 'AF', 'TUN'),
('TR', 'Turkey', 90, '₺', 'Ankara', 'TRY', 'AS', 'TUR'),
('TM', 'Turkmenistan', 7370, 'T', 'Ashgabat', 'TMT', 'AS', 'TKM'),
('TC', 'Turks and Caicos Islands', 1649, '$', 'Cockburn Town', 'USD', 'NA', 'TCA'),
('TV', 'Tuvalu', 688, '$', 'Funafuti', 'AUD', 'OC', 'TUV'),
('UG', 'Uganda', 256, 'USh', 'Kampala', 'UGX', 'AF', 'UGA'),
('UA', 'Ukraine', 380, '₴', 'Kiev', 'UAH', 'EU', 'UKR'),
('AE', 'United Arab Emirates', 971, 'إ.د', 'Abu Dhabi', 'AED', 'AS', 'ARE'),
('GB', 'United Kingdom', 44, '£', 'London', 'GBP', 'EU', 'GBR'),
('US', 'United States', 1, '$', 'Washington', 'USD', 'NA', 'USA'),
('UM', 'United States Minor Outlying Islands', 1, '$', '', 'USD', 'NA', 'UMI'),
('UY', 'Uruguay', 598, '$', 'Montevideo', 'UYU', 'SA', 'URY'),
('UZ', 'Uzbekistan', 998, 'лв', 'Tashkent', 'UZS', 'AS', 'UZB'),
('VU', 'Vanuatu', 678, 'VT', 'Port Vila', 'VUV', 'OC', 'VUT'),
('VE', 'Venezuela', 58, 'Bs', 'Caracas', 'VEF', 'SA', 'VEN'),
('VN', 'Viet Nam', 84, '₫', 'Hanoi', 'VND', 'AS', 'VNM'),
('VG', 'Virgin Islands, British', 1284, '$', 'Road Town', 'USD', 'NA', 'VGB'),
('VI', 'Virgin Islands, U.s.', 1340, '$', 'Charlotte Amalie', 'USD', 'NA', 'VIR'),
('WF', 'Wallis and Futuna', 681, '₣', 'Mata Utu', 'XPF', 'OC', 'WLF'),
('EH', 'Western Sahara', 212, 'MAD', 'El-Aaiun', 'MAD', 'AF', 'ESH'),
('YE', 'Yemen', 967, '﷼', 'Sanaa', 'YER', 'AS', 'YEM'),
('ZM', 'Zambia', 260, 'ZK', 'Lusaka', 'ZMW', 'AF', 'ZMB'),
('ZW', 'Zimbabwe', 263, '$', 'Harare', 'ZWL', 'AF', 'ZWE');

INSERT INTO `persons` (`last_name`, `first_name`, `country_code`) VALUES
('Doe', 'John', 'US'),
('Cole', 'Adam', 'ES'),
('Best', 'Gianluca', 'GB'),
('Lyons', 'Brianna', 'AU'),
('Mcmillan', 'Zoe', 'US'),
('Baker', 'Liam', 'AU'),
('Armstrong', 'Sophie', 'NL'),
('Mercado', 'Alannah', 'MX'),
('Lee', 'John', 'HK'),
('Xi', 'JP', 'CN'),
('Ruairi', 'Blake', 'IN'),
('Richards', 'Hayley', 'ZA'),
('Harris', 'Ella', 'ZA');